package com.teaminternational.enterthezone.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.time.Duration;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@PlanningEntity
public class ScheduledEvent {
    @PlanningId Long id;
    String eventName;
    Duration duration;
    @PlanningVariable TimeEntry startTime;

    public ScheduledEvent(Long id, String eventName, Duration duration) {
        this.id = id;
        this.eventName = eventName;
        this.duration = duration;
    }

    public LocalTime getStartTimePretty() {
        return startTime.startTime();
    }

    public LocalTime getEndTimePretty() {
        return startTime.startTime().plus(duration);
    }

    @Override
    public String toString() {
        return "ScheduledEvent{" +
                "eventName = '" + eventName + '\'' +
                ", time = %s - %s".formatted(getStartTimePretty(), getEndTimePretty()) +
                '}';
    }
}
