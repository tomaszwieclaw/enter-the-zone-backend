package com.teaminternational.enterthezone.infrastructure.persistence.scheduledevent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduledEventSpringDataRepository extends JpaRepository<ScheduledEventEntity, UUID> {
}
