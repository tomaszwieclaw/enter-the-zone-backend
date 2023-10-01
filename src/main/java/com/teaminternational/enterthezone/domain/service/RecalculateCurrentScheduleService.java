package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.model.TimeTable;
import com.teaminternational.enterthezone.domain.repository.PlannedEventRepository;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.GenerateInTheZoneEventsUseCase;
import com.teaminternational.enterthezone.domain.usecase.GenerateLunchTimeEventUseCase;
import com.teaminternational.enterthezone.domain.usecase.OrganizeSingleDayUseCase;
import com.teaminternational.enterthezone.domain.usecase.RecalculateCurrentScheduleUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecalculateCurrentScheduleService implements RecalculateCurrentScheduleUseCase {
    private final ScheduledEventRepository scheduledEventRepository;
    private final OrganizeSingleDayUseCase organizeSingleDayUseCase;
    private final PlannedEventRepository plannedEventRepository;
    private final GenerateLunchTimeEventUseCase generateLunchTimeEventUseCase;
    private final GenerateInTheZoneEventsUseCase generateInTheZoneEventsUseCase;

    @Override
    public void execute() {
        log.info("Recalculating schedule...");
        //hardcoded dates for the PoC purpose
        processDay(LocalDate.of(2023, Month.OCTOBER, 2));
        processDay(LocalDate.of(2023, Month.OCTOBER, 3));
        processDay(LocalDate.of(2023, Month.OCTOBER, 4));
        processDay(LocalDate.of(2023, Month.OCTOBER, 5));
        processDay(LocalDate.of(2023, Month.OCTOBER, 6));
        log.info("...done");
    }

    private void processDay(LocalDate date) {
        log.info("Processing %s (%s)".formatted(date, date.getDayOfWeek()));
        final List<ScheduledEvent> events = new ArrayList<>(scheduledEventRepository.findByDate(date));
        events.add(generateLunchTimeEventUseCase.execute(date));
        events.addAll(generateInTheZoneEventsUseCase.execute(date));
        final TimeTable problemDefinition = new TimeTable(
                events
        );
        final TimeTable solution = organizeSingleDayUseCase.execute(problemDefinition);
        plannedEventRepository.saveSingleDay(date, solution.getScheduledEvents());
    }
}
