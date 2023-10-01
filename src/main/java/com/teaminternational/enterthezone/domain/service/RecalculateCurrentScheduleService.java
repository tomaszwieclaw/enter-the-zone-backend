package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.TimeTable;
import com.teaminternational.enterthezone.domain.repository.PlannedEventRepository;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.OrganizeSingleDayUseCase;
import com.teaminternational.enterthezone.domain.usecase.RecalculateCurrentScheduleUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
        final TimeTable problemDefinition = new TimeTable(
                workingHours(),
                scheduledEventRepository.findByDate(date)
        );
        final TimeTable solution = organizeSingleDayUseCase.execute(problemDefinition);
        plannedEventRepository.saveSingleDay(date, solution.getScheduledEvents());
    }

    private List<LocalTime> workingHours() {
        List<LocalTime> timeEntries = new ArrayList<>();
        LocalTime dayStartsAt = LocalTime.of(9, 0);
        timeEntries.add(dayStartsAt);
        LocalTime nextSlotStartsAt = dayStartsAt.plus(TimeTable.DEFAULT_DURATION);
        while (nextSlotStartsAt.isBefore(LocalTime.of(17, 1))) {
            timeEntries.add(nextSlotStartsAt);
            nextSlotStartsAt = nextSlotStartsAt.plus(TimeTable.DEFAULT_DURATION);
        }
        return timeEntries;
    }
}
