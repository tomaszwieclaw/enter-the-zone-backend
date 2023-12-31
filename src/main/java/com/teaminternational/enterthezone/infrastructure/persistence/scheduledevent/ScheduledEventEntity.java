package com.teaminternational.enterthezone.infrastructure.persistence.scheduledevent;

import com.teaminternational.enterthezone.domain.model.EventPriority;
import com.teaminternational.enterthezone.domain.model.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "scheduled_event", schema = "enter_the_zone")
@Entity
public class ScheduledEventEntity {
    @Id
    private UUID id;

    private String eventName;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private long duration;

    private LocalDate eventDate;

    private LocalTime startTime;

    @Enumerated(EnumType.STRING)
    private EventPriority priority;

    private LocalTime minPreferredStartTime;

    private LocalTime maxPreferredStartTime;
}
