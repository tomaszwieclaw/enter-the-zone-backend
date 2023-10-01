package com.teaminternational.enterthezone.infrastructure.persistence.scheduledevent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ScheduledEventSpringDataRepository extends JpaRepository<ScheduledEventEntity, UUID> {

    List<ScheduledEventEntity> findAllByEventDate(LocalDate eventDate);

    List<ScheduledEventEntity> findAllByEventDateIsNull();
}
