package com.teaminternational.enterthezone.domain.factory;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventsRequest;
import com.teaminternational.enterthezone.domain.model.EventPriority;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Component
public class ScheduledEventFactory {

    public ScheduledEvent create(CreateScheduledEventsRequest.NewScheduledEvent newScheduledEvent) {
        return new ScheduledEvent(
                UUID.randomUUID(),
                newScheduledEvent.getEventName(),
                Duration.ofMinutes(newScheduledEvent.getDurationMinutes()),
                newScheduledEvent.getEventDate(),
                newScheduledEvent.getStartTime(),
                Optional.ofNullable(newScheduledEvent.getPriority()).orElse(EventPriority.NORMAL),
                newScheduledEvent.getMinPreferredStartTime(),
                newScheduledEvent.getMaxPreferredStartTime()
        );
    }
}
