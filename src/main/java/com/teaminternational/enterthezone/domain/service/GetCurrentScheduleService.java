package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.domain.model.PlannedSchedule;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;
import com.teaminternational.enterthezone.domain.repository.PlannedEventRepository;
import com.teaminternational.enterthezone.domain.usecase.GetCurrentScheduleUseCase;
import com.teaminternational.enterthezone.infrastructure.persistence.plannedevent.PlannedEventEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class GetCurrentScheduleService implements GetCurrentScheduleUseCase {
    private final PlannedEventRepository plannedEventRepository;

    @Override
    public GetCurrentScheduleResponse execute() {
        final PlannedSchedule currentSchedule = plannedEventRepository.getCurrentSchedule();
        final var weeklySchedule = new GetCurrentScheduleResponse.WeeklySchedule();

        var monday = new GetCurrentScheduleResponse.DailySchedule();
        monday.setDate(currentSchedule.monday().getDate());
        monday.setWorkdayStartTime(currentSchedule.monday().getWorkdayStartTime());
        monday.setWorkdayEndTime(currentSchedule.monday().getWorkdayEndTime());
        var mondayEvents = currentSchedule
                .mondayEvents()
                .stream()
                .map(mapEvent())
                .toList();
        monday.setScheduledEvents(mondayEvents);
        weeklySchedule.setMonday(monday);

        var tuesday = new GetCurrentScheduleResponse.DailySchedule();
        tuesday.setDate(currentSchedule.tuesday().getDate());
        tuesday.setWorkdayStartTime(currentSchedule.tuesday().getWorkdayStartTime());
        tuesday.setWorkdayEndTime(currentSchedule.tuesday().getWorkdayEndTime());
        var tuesdayEvents = currentSchedule
                .tuesdayEvents()
                .stream()
                .map(mapEvent())
                .toList();
        tuesday.setScheduledEvents(tuesdayEvents);
        weeklySchedule.setTuesday(tuesday);

        var wednesday = new GetCurrentScheduleResponse.DailySchedule();
        wednesday.setDate(currentSchedule.wednesday().getDate());
        wednesday.setWorkdayStartTime(currentSchedule.wednesday().getWorkdayStartTime());
        wednesday.setWorkdayEndTime(currentSchedule.wednesday().getWorkdayEndTime());
        var wednesdayEvents = currentSchedule
                .wednesdayEvents()
                .stream()
                .map(mapEvent())
                .toList();
        wednesday.setScheduledEvents(wednesdayEvents);
        weeklySchedule.setWednesday(wednesday);

        var thursday = new GetCurrentScheduleResponse.DailySchedule();
        thursday.setDate(currentSchedule.thursday().getDate());
        thursday.setWorkdayStartTime(currentSchedule.thursday().getWorkdayStartTime());
        thursday.setWorkdayEndTime(currentSchedule.thursday().getWorkdayEndTime());
        var thursdayEvents = currentSchedule
                .thursdayEvents()
                .stream()
                .map(mapEvent())
                .toList();
        thursday.setScheduledEvents(thursdayEvents);
        weeklySchedule.setThursday(thursday);

        var friday = new GetCurrentScheduleResponse.DailySchedule();
        friday.setDate(currentSchedule.friday().getDate());
        friday.setWorkdayStartTime(currentSchedule.friday().getWorkdayStartTime());
        friday.setWorkdayEndTime(currentSchedule.friday().getWorkdayEndTime());
        var fridayEvents = currentSchedule
                .fridayEvents()
                .stream()
                .map(mapEvent())
                .toList();
        friday.setScheduledEvents(fridayEvents);
        weeklySchedule.setFriday(friday);

        var saturday = new GetCurrentScheduleResponse.DailySchedule();
        saturday.setDate(LocalDate.of(2023, Month.OCTOBER, 7));
        saturday.setScheduledEvents(Collections.emptyList());
        weeklySchedule.setSaturday(saturday);

        var sunday = new GetCurrentScheduleResponse.DailySchedule();
        sunday.setDate(LocalDate.of(2023, Month.OCTOBER, 8));
        sunday.setScheduledEvents(Collections.emptyList());
        weeklySchedule.setSunday(sunday);

        return new GetCurrentScheduleResponse(
                LocalDateTime.now(),
                LocalDate.of(2023, Month.OCTOBER, 2),
                Collections.singletonList(weeklySchedule)
        );
    }

    private static Function<PlannedEventEntity, ScheduledEventDTO> mapEvent() {
        return e -> new ScheduledEventDTO(
                e.getEventId(),
                e.getEventDate(),
                e.getEventName(),
                e.getEventType(),
                e.getStartTime(),
                e.getEndTime(),
                e.getTotalDurationMin(),
                e.getPriority(),
                e.getMinPreferredStartTime(),
                e.getMaxPreferredStartTime()
        );
    }
}
