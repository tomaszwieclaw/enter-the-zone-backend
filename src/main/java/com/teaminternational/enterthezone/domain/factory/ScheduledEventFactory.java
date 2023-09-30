package com.teaminternational.enterthezone.domain.factory;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventRequest;
import com.teaminternational.enterthezone.domain.model.EventPriority;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Component
public class ScheduledEventFactory {

    public ScheduledEvent create(CreateScheduledEventRequest request) {
        return new ScheduledEvent(
                UUID.randomUUID(),
                request.eventName(),
                Duration.ofMinutes(request.durationMinutes()),
                request.eventDate(),
                request.startTime(),
                Optional.ofNullable(request.priority()).orElse(EventPriority.NORMAL),
                request.minPreferredStartTime(),
                request.maxPreferredStartTime()
        );
    }
}
