package com.teaminternational.enterthezone.infrastructure.persistence.plannedevent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlannedEventSpringDataRepository extends JpaRepository<PlannedEventEntity, UUID> {

    void deleteAllByPlannedDayId(UUID plannedDayId);

    List<PlannedEventEntity> findAllByPlannedDayIdOrderByStartTime(UUID plannedDayId);
}
