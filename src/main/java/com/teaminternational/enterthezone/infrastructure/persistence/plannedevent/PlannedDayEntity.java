package com.teaminternational.enterthezone.infrastructure.persistence.plannedevent;

import jakarta.persistence.Column;
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
@Table(name = "planned_day", schema = "enter_the_zone")
@Entity
public class PlannedDayEntity {
    @Id
    private UUID id;

    @Column(name = "day_date")
    private LocalDate date;

    private LocalTime workdayStartTime;

    private LocalTime workdayEndTime;
}
