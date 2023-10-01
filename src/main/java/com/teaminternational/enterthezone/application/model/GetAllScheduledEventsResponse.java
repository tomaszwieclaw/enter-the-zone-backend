package com.teaminternational.enterthezone.application.model;

import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;

import java.util.List;

public record GetAllScheduledEventsResponse(
        List<ScheduledEventDTO> scheduledEvents
) {
}
