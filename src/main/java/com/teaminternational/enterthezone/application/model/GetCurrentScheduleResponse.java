package com.teaminternational.enterthezone.application.model;

import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class GetCurrentScheduleResponse {
    private final LocalDateTime lastUpdated;
    private final List<WeeklySchedule> weeklySchedules;

    @Getter
    @Setter
    public static class WeeklySchedule {
        private DailySchedule monday;
        private DailySchedule tuesday;
        private DailySchedule wednesday;
        private DailySchedule thursday;
        private DailySchedule friday;
        private DailySchedule saturday;
        private DailySchedule sunday;
    }

    @Getter
    @Setter
    public static class DailySchedule {
        private LocalDate date;
        private LocalTime workdayStartTime;
        private LocalTime workdayEndTime;
        private List<ScheduledEventDTO> scheduledEvents;
    }
}
