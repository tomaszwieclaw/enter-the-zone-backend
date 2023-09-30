package com.teaminternational.enterthezone.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PlanningEntity
public class ScheduledEvent {
    private @PlanningId UUID id;
    private String eventName;
    private Duration duration;
    private LocalDate eventDate;
    private @PlanningVariable LocalTime startTime;
    private EventPriority priority;
    private LocalTime minPreferredStartTime;
    private LocalTime maxPreferredStartTime;

    public LocalTime getStartTimePretty() {
        return startTime;
    }

    public LocalTime getEndTimePretty() {
        return startTime.plus(duration);
    }

    public ScheduledEventDTO toDTO() {
        return new ScheduledEventDTO(
                id,
                eventName,
                startTime,
                startTime.plus(duration),
                duration.toMinutes()
        );
    }

    @Override
    public String toString() {
        return "ScheduledEvent{" +
                "eventName = '" + eventName + '\'' +
                ", time = %s - %s".formatted(getStartTimePretty(), getEndTimePretty()) +
                '}';
    }
}
