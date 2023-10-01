package com.teaminternational.enterthezone.domain.model;

import com.teaminternational.enterthezone.infrastructure.persistence.plannedevent.PlannedDayEntity;
import com.teaminternational.enterthezone.infrastructure.persistence.plannedevent.PlannedEventEntity;

import java.util.List;

public record PlannedSchedule(
        PlannedDayEntity monday,
        List<PlannedEventEntity> mondayEvents,
        PlannedDayEntity tuesday,
        List<PlannedEventEntity> tuesdayEvents,
        PlannedDayEntity wednesday,
        List<PlannedEventEntity> wednesdayEvents,
        PlannedDayEntity thursday,
        List<PlannedEventEntity> thursdayEvents,
        PlannedDayEntity friday,
        List<PlannedEventEntity> fridayEvents
) {
}
