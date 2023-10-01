package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventsRequest;
import com.teaminternational.enterthezone.domain.factory.ScheduledEventFactory;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.RecalculateCurrentScheduleUseCase;
import com.teaminternational.enterthezone.domain.usecase.ScheduleNewEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduleNewEventService implements ScheduleNewEventUseCase {
    private final ScheduledEventFactory scheduledEventFactory;
    private final ScheduledEventRepository scheduledEventRepository;
    private final RecalculateCurrentScheduleUseCase recalculateCurrentScheduleUseCase;

    @Override
    public ScheduledEventDTO execute(CreateScheduledEventsRequest.NewScheduledEvent newScheduledEvent) {
        ScheduledEvent scheduledEvent = scheduledEventFactory.create(newScheduledEvent);
        scheduledEventRepository.save(scheduledEvent);
        recalculateCurrentScheduleUseCase.execute();
        return scheduledEvent.toDTO();
    }
}
