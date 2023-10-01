package com.teaminternational.enterthezone.application.model;

import com.teaminternational.enterthezone.domain.model.EventPriority;
import com.teaminternational.enterthezone.domain.model.EventType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateScheduledEventsRequest {

    private List<NewScheduledEvent> scheduledEvents;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class NewScheduledEvent {
        private String eventName;
        private EventType eventType;
        private LocalDate eventDate;
        private LocalTime startTime;
        private long durationMinutes;
        private EventPriority priority;
        private LocalTime minPreferredStartTime;
        private LocalTime maxPreferredStartTime;
    }
}
