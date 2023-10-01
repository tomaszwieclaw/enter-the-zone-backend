package com.teaminternational.enterthezone.domain.repository;

import com.teaminternational.enterthezone.domain.model.PlannedSchedule;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;

import java.time.LocalDate;
import java.util.List;

public interface PlannedEventRepository {

    void saveSingleDay(LocalDate date, List<ScheduledEvent> events);

    PlannedSchedule getCurrentSchedule();
}
