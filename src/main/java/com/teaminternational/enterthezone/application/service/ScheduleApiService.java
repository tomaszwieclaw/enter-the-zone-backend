package com.teaminternational.enterthezone.application.service;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.application.model.GetCurrentScheduleStatusResponse;
import com.teaminternational.enterthezone.domain.model.EventPriority;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;
import com.teaminternational.enterthezone.domain.model.TimeTableStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ScheduleApiService {

    public GetCurrentScheduleResponse getCurrentSchedule() {
        final var monday = new GetCurrentScheduleResponse.DailySchedule();
        monday.setDate(LocalDate.of(2023, Month.OCTOBER, 2));
        monday.setWorkdayStartTime(LocalTime.of(9, 0));
        monday.setWorkdayEndTime(LocalTime.of(17, 0));
        monday.setScheduledEvents(
                List.of(
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                monday.getDate(),
                                "Daily Scrum",
                                LocalTime.of(9, 0),
                                LocalTime.of(9, 15),
                                15,
                                EventPriority.NORMAL,
                                null,
                                null
                        ),
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                monday.getDate(),
                                "Tech Interview",
                                LocalTime.of(10, 0),
                                LocalTime.of(11, 30),
                                90,
                                EventPriority.NORMAL,
                                null,
                                null
                        ),
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                monday.getDate(),
                                "In the zone (1)",
                                LocalTime.of(12, 0),
                                LocalTime.of(13, 0),
                                60,
                                EventPriority.NORMAL,
                                null,
                                null
                        ),
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                monday.getDate(),
                                "Lunch",
                                LocalTime.of(13, 15),
                                LocalTime.of(14, 0),
                                45,
                                EventPriority.NORMAL,
                                LocalTime.of(13, 30),
                                LocalTime.of(15, 30)
                        ),
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                monday.getDate(),
                                "In the zone (2)",
                                LocalTime.of(14, 15),
                                LocalTime.of(15, 15),
                                60,
                                EventPriority.NORMAL,
                                null,
                                null
                        ),
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                monday.getDate(),
                                "Management Duties",
                                LocalTime.of(15, 30),
                                LocalTime.of(17, 0),
                                90,
                                EventPriority.NORMAL,
                                null,
                                null
                        )
                )
        );

        final var tuesday = new GetCurrentScheduleResponse.DailySchedule();
        tuesday.setDate(LocalDate.of(2023, Month.OCTOBER, 3));
        tuesday.setWorkdayStartTime(LocalTime.of(9, 0));
        tuesday.setWorkdayEndTime(LocalTime.of(17, 0));
        tuesday.setScheduledEvents(
                List.of(
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                tuesday.getDate(),
                                "Daily Scrum",
                                LocalTime.of(9, 0),
                                LocalTime.of(9, 15),
                                15,
                                EventPriority.NORMAL,
                                null,
                                null
                        )
                )
        );

        final var wednesday = new GetCurrentScheduleResponse.DailySchedule();
        wednesday.setDate(LocalDate.of(2023, Month.OCTOBER, 4));
        wednesday.setWorkdayStartTime(LocalTime.of(9, 0));
        wednesday.setWorkdayEndTime(LocalTime.of(17, 0));
        wednesday.setScheduledEvents(
                List.of(
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                wednesday.getDate(),
                                "Daily Scrum",
                                LocalTime.of(9, 0),
                                LocalTime.of(9, 15),
                                15,
                                EventPriority.NORMAL,
                                null,
                                null
                        )
                )
        );

        final var thursday = new GetCurrentScheduleResponse.DailySchedule();
        thursday.setDate(LocalDate.of(2023, Month.OCTOBER, 5));
        thursday.setWorkdayStartTime(LocalTime.of(9, 0));
        thursday.setWorkdayEndTime(LocalTime.of(17, 0));
        thursday.setScheduledEvents(
                List.of(
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                thursday.getDate(),
                                "Daily Scrum",
                                LocalTime.of(9, 0),
                                LocalTime.of(9, 15),
                                15,
                                EventPriority.NORMAL,
                                null,
                                null
                        )
                )
        );

        final var friday = new GetCurrentScheduleResponse.DailySchedule();
        friday.setDate(LocalDate.of(2023, Month.OCTOBER, 6));
        friday.setWorkdayStartTime(LocalTime.of(9, 0));
        friday.setWorkdayEndTime(LocalTime.of(17, 0));
        friday.setScheduledEvents(
                List.of(
                        new ScheduledEventDTO(
                                UUID.randomUUID(),
                                friday.getDate(),
                                "Daily Scrum",
                                LocalTime.of(9, 0),
                                LocalTime.of(9, 15),
                                15,
                                EventPriority.NORMAL,
                                null,
                                null
                        )
                )
        );

        final var saturday = new GetCurrentScheduleResponse.DailySchedule();
        saturday.setDate(LocalDate.of(2023, Month.OCTOBER, 7));
        saturday.setScheduledEvents(Collections.emptyList());

        final var sunday = new GetCurrentScheduleResponse.DailySchedule();
        sunday.setDate(LocalDate.of(2023, Month.OCTOBER, 8));
        sunday.setScheduledEvents(Collections.emptyList());

        final var weeklySchedule = new GetCurrentScheduleResponse.WeeklySchedule();
        weeklySchedule.setMonday(monday);
        weeklySchedule.setTuesday(tuesday);
        weeklySchedule.setWednesday(wednesday);
        weeklySchedule.setThursday(thursday);
        weeklySchedule.setFriday(friday);
        weeklySchedule.setSaturday(saturday);
        weeklySchedule.setSunday(sunday);

        return new GetCurrentScheduleResponse(
                LocalDateTime.now(),
                LocalDate.of(2023, Month.OCTOBER, 2),
                Collections.singletonList(weeklySchedule)
        );
    }

    public GetCurrentScheduleStatusResponse getCurrentScheduleStatus() {
        return new GetCurrentScheduleStatusResponse(
                TimeTableStatus.UP_TO_DATE
        );
    }
}
