package com.teaminternational.enterthezone.domain.repository;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;

import java.util.List;

public interface ScheduledEventRepository {

    void save(ScheduledEvent scheduledEvent);

    List<ScheduledEvent> findAll();
}
