package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.model.TimeTable;
import com.teaminternational.enterthezone.domain.repository.PlannedEventRepository;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecalculateCurrentScheduleService implements RecalculateCurrentScheduleUseCase {
    private static final long MAX_DAILY_CAPACITY_MINUTES = Duration.ofHours(6).toMinutes();

    private final ScheduledEventRepository scheduledEventRepository;
    private final OrganizeSingleDayUseCase organizeSingleDayUseCase;
    private final PlannedEventRepository plannedEventRepository;
    private final GenerateLunchTimeEventUseCase generateLunchTimeEventUseCase;
    private final GenerateInTheZoneEventsUseCase generateInTheZoneEventsUseCase;
    private final GenerateTaskEventsUseCase generateTaskEventsUseCase;

    @Override
    public void execute() {
        log.info("Recalculating schedule...");
        //hardcoded dates for the PoC purpose
        final List<ScheduledEvent> floatingTaskEvents = new ArrayList<>(generateTaskEventsUseCase.execute());
        processDay(LocalDate.of(2023, Month.OCTOBER, 2), floatingTaskEvents);
        processDay(LocalDate.of(2023, Month.OCTOBER, 3), floatingTaskEvents);
        processDay(LocalDate.of(2023, Month.OCTOBER, 4), floatingTaskEvents);
        processDay(LocalDate.of(2023, Month.OCTOBER, 5), floatingTaskEvents);
        processDay(LocalDate.of(2023, Month.OCTOBER, 6), floatingTaskEvents);
        log.info("...done");
    }

    private void processDay(LocalDate date, List<ScheduledEvent> taskEvents) {
        log.info("Processing %s (%s)".formatted(date, date.getDayOfWeek()));
        final List<ScheduledEvent> events = new ArrayList<>(scheduledEventRepository.findByDate(date));
        events.add(generateLunchTimeEventUseCase.execute(date));
        events.addAll(generateInTheZoneEventsUseCase.execute(date));
        fitFloatingTasksIntoSchedule(date, events, taskEvents);
        final TimeTable problemDefinition = new TimeTable(
                events
        );
        final TimeTable solution = organizeSingleDayUseCase.execute(problemDefinition);
        plannedEventRepository.saveSingleDay(date, solution.getScheduledEvents());
    }

    private void fitFloatingTasksIntoSchedule(
            LocalDate date,
            List<ScheduledEvent> schedule,
            List<ScheduledEvent> tasks
    ) {
        long capacityLeft = MAX_DAILY_CAPACITY_MINUTES - calculateCurrentWorkingDayUsage(schedule);
        while (capacityLeft >= 15) {
            Optional<ScheduledEvent> firstFound = tasks
                    .stream()
                    .filter(t -> t.getDuration().toMinutes() <= (MAX_DAILY_CAPACITY_MINUTES - calculateCurrentWorkingDayUsage(schedule)))
                    .findFirst();
            if (firstFound.isPresent()) {
                ScheduledEvent task = firstFound.get();
                task.setEventDate(date);
                tasks.remove(task);
                schedule.add(task);
                capacityLeft = MAX_DAILY_CAPACITY_MINUTES - calculateCurrentWorkingDayUsage(schedule);
            } else {
                break;
            }
        }
    }

    private long calculateCurrentWorkingDayUsage(List<ScheduledEvent> schedule) {
        return schedule
                .stream()
                .map(ScheduledEvent::getDuration)
                .mapToLong(Duration::toMinutes)
                .sum();
    }
}
