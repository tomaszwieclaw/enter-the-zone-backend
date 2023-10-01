package com.teaminternational.enterthezone.infrastructure.persistence.plannedevent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface PlannedDaySpringDataRepository extends JpaRepository<PlannedDayEntity, UUID> {

    Optional<PlannedDayEntity> findByDate(LocalDate date);
}
