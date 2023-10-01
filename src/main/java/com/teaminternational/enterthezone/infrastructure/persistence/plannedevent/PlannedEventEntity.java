package com.teaminternational.enterthezone.infrastructure.persistence.plannedevent;

import com.teaminternational.enterthezone.domain.model.EventPriority;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "planned_event", schema = "enter_the_zone")
@Entity
public class PlannedEventEntity {
    @Id
    private UUID id;

    private UUID plannedDayId;

    private UUID eventId;

    private LocalDate eventDate;

    private String eventName;

    private LocalTime startTime;

    private LocalTime endTime;

    private long totalDurationMin;

    private EventPriority priority;

    private LocalTime minPreferredStartTime;

    private LocalTime maxPreferredStartTime;
}
