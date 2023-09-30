package com.teaminternational.enterthezone.domain.model;

import java.time.LocalTime;
import java.util.UUID;

public record ScheduledEventDTO(
        UUID id,
        String eventName,
        LocalTime startTime,
        LocalTime endTime,
        long totalDurationMin
) {
}
