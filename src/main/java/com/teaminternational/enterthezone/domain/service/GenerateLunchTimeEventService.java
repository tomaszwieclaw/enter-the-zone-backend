package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.BasicSettings;
import com.teaminternational.enterthezone.domain.model.EventPriority;
import com.teaminternational.enterthezone.domain.model.EventType;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.repository.BasicSettingsRepository;
import com.teaminternational.enterthezone.domain.usecase.GenerateLunchTimeEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GenerateLunchTimeEventService implements GenerateLunchTimeEventUseCase {
    private final BasicSettingsRepository basicSettingsRepository;

    @Override
    public ScheduledEvent execute(LocalDate date) {
        final BasicSettings basicSettings = basicSettingsRepository.findAll();
        return new ScheduledEvent(
                UUID.randomUUID(),
                "Lunch",
                EventType.LUNCH,
                Duration.ofMinutes(basicSettings.getLunchTimeDurationMinutes()),
                date,
                null,
                EventPriority.NORMAL,
                basicSettings.getPreferredLunchTimeWindowStart(),
                basicSettings.getPreferredLunchTimeWindowEnd()
        );
    }
}
