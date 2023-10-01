package com.teaminternational.enterthezone.infrastructure.persistence.plannedevent;

import com.teaminternational.enterthezone.domain.model.PlannedSchedule;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.repository.PlannedEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class PlannedEventRepositoryAdapter implements PlannedEventRepository {
    private final PlannedDaySpringDataRepository plannedDaySpringDataRepository;
    private final PlannedEventSpringDataRepository plannedEventSpringDataRepository;

    @Override
    public void saveSingleDay(LocalDate date, List<ScheduledEvent> events) {
        PlannedDayEntity plannedDay = plannedDaySpringDataRepository.findByDate(date)
                .orElseGet(() -> new PlannedDayEntity(
                        UUID.randomUUID(),
                        date,
                        LocalTime.of(9, 0),
                        LocalTime.of(17, 0)
                ));
        plannedDaySpringDataRepository.deleteById(plannedDay.getId());
        plannedDaySpringDataRepository.save(plannedDay);
        events
                .stream()
                .map(ScheduledEvent::toDTO)
                .map(e -> new PlannedEventEntity(
                        UUID.randomUUID(),
                        plannedDay.getId(),
                        e.id(),
                        e.eventDate(),
                        e.eventName(),
                        e.eventType(),
                        e.startTime(),
                        e.endTime(),
                        e.totalDurationMin(),
                        e.priority(),
                        e.minPreferredStartTime(),
                        e.maxPreferredStartTime()
                ))
                .forEach(plannedEventSpringDataRepository::save);
    }

    @Override
    public PlannedSchedule getCurrentSchedule() {
        var monday = plannedDaySpringDataRepository
                .findByDate(LocalDate.of(2023, Month.OCTOBER, 2))
                .orElseGet(() -> emptyDay(LocalDate.of(2023, Month.OCTOBER, 2)));
        var tuesday = plannedDaySpringDataRepository
                .findByDate(LocalDate.of(2023, Month.OCTOBER, 3))
                .orElseGet(() -> emptyDay(LocalDate.of(2023, Month.OCTOBER, 3)));
        var wednesday = plannedDaySpringDataRepository
                .findByDate(LocalDate.of(2023, Month.OCTOBER, 4))
                .orElseGet(() -> emptyDay(LocalDate.of(2023, Month.OCTOBER, 4)));
        var thursday = plannedDaySpringDataRepository
                .findByDate(LocalDate.of(2023, Month.OCTOBER, 5))
                .orElseGet(() -> emptyDay(LocalDate.of(2023, Month.OCTOBER, 5)));
        var friday = plannedDaySpringDataRepository
                .findByDate(LocalDate.of(2023, Month.OCTOBER, 6))
                .orElseGet(() -> emptyDay(LocalDate.of(2023, Month.OCTOBER, 6)));
        return new PlannedSchedule(
                monday,
                plannedEventSpringDataRepository.findAllByPlannedDayId(monday.getId()),
                tuesday,
                plannedEventSpringDataRepository.findAllByPlannedDayId(tuesday.getId()),
                wednesday,
                plannedEventSpringDataRepository.findAllByPlannedDayId(wednesday.getId()),
                thursday,
                plannedEventSpringDataRepository.findAllByPlannedDayId(thursday.getId()),
                friday,
                plannedEventSpringDataRepository.findAllByPlannedDayId(friday.getId())
        );
    }

    private PlannedDayEntity emptyDay(LocalDate date) {
        return new PlannedDayEntity(
                UUID.randomUUID(),
                date,
                LocalTime.of(9, 0),
                LocalTime.of(17, 0)
        );
    }
}
