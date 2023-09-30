package com.teaminternational.enterthezone.application.model;

import com.teaminternational.enterthezone.domain.model.EventPriority;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateScheduledEventRequest(
        String eventName,
        LocalDate eventDate,
        LocalTime startTime,
        int durationMinutes,
        EventPriority priority,
        LocalTime minPreferredStartTime,
        LocalTime maxPreferredStartTime
) {
}
