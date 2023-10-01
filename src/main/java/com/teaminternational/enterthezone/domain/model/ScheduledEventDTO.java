package com.teaminternational.enterthezone.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record ScheduledEventDTO(
        UUID id,
        LocalDate eventDate,
        String eventName,
        LocalTime startTime,
        LocalTime endTime,
        long totalDurationMin,
        EventPriority priority,
        LocalTime minPreferredStartTime,
        LocalTime maxPreferredStartTime
) {
}
