package com.teaminternational.enterthezone.domain.repository;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;

import java.time.LocalDate;
import java.util.List;

public interface ScheduledEventRepository {

    void save(ScheduledEvent scheduledEvent);

    List<ScheduledEvent> findAll();

    List<ScheduledEvent> findByDate(LocalDate date);
}
