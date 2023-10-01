package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.*;
import com.teaminternational.enterthezone.domain.repository.BasicSettingsRepository;
import com.teaminternational.enterthezone.domain.usecase.GenerateInTheZoneEventsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class GenerateInTheZoneEventsService implements GenerateInTheZoneEventsUseCase {
    private final BasicSettingsRepository basicSettingsRepository;
    private final TimeEntriesProvider timeEntriesProvider;

    @Override
    public List<ScheduledEvent> execute(LocalDate date) {
        final BasicSettings basicSettings = basicSettingsRepository.findAll();
        final Duration singleSession = Duration.ofMinutes(basicSettings.getInTheZoneSingleSessionMinutes());
        Duration timeLeft = Duration.ofMinutes(basicSettings.getInTheZoneTotalMinutes());
        final List<ScheduledEvent> events = new ArrayList<>();
        while (timeLeft.toMinutes() > 0) {
            final Duration eventDuration;
            if (singleSession.toMinutes() <= timeLeft.toMinutes()) {
                eventDuration = singleSession;
                timeLeft = timeLeft.minus(singleSession);
            } else {
                eventDuration = timeLeft;
                timeLeft = Duration.ZERO;
            }
            events.add(new ScheduledEvent(
                    UUID.randomUUID(),
                    "Focus Time",
                    EventType.IN_THE_ZONE,
                    eventDuration,
                    date,
                    null,
                    timeEntriesProvider.getAvailableTimeEntries(EventType.IN_THE_ZONE, null),
                    EventPriority.NORMAL,
                    null,
                    null
            ));
        }
        return events;
    }
}
