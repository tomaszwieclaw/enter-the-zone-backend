package com.teaminternational.enterthezone.infrastructure.persistence.scheduledevent;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ScheduledEventRepositoryAdapter implements ScheduledEventRepository {
    private final ScheduledEventSpringDataRepository scheduledEventSpringDataRepository;
    private final ScheduledEventEntityMapper scheduledEventEntityMapper;

    @Override
    public void save(ScheduledEvent scheduledEvent) {
        Optional.of(scheduledEvent)
                .map(scheduledEventEntityMapper::mapToDatabaseEntity)
                .map(scheduledEventSpringDataRepository::save)
                .orElseThrow();
    }

    @Override
    public List<ScheduledEvent> findAll() {
        return scheduledEventSpringDataRepository
                .findAll()
                .stream()
                .map(scheduledEventEntityMapper::mapToDomainEntity)
                .toList();
    }

    @Override
    public List<ScheduledEvent> findByDate(LocalDate date) {
        return scheduledEventSpringDataRepository
                .findAllByEventDate(date)
                .stream()
                .map(scheduledEventEntityMapper::mapToDomainEntity)
                .toList();
    }

    @Override
    public List<ScheduledEvent> findAllFloatingTasks() {
        return scheduledEventSpringDataRepository
                .findAllByEventDateIsNull()
                .stream()
                .map(scheduledEventEntityMapper::mapToDomainEntity)
                .toList();
    }
}
