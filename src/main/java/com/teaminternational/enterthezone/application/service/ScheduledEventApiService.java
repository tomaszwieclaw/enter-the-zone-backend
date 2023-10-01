package com.teaminternational.enterthezone.application.service;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventsRequest;
import com.teaminternational.enterthezone.application.model.GetAllScheduledEventsResponse;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.GetAllScheduledEventsUseCase;
import com.teaminternational.enterthezone.domain.usecase.RecalculateCurrentScheduleUseCase;
import com.teaminternational.enterthezone.domain.usecase.ScheduleNewEventUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduledEventApiService {
    private final ScheduleNewEventUseCase scheduleNewEventUseCase;
    private final GetAllScheduledEventsUseCase getAllScheduledEventsUseCase;
    private final ScheduledEventRepository scheduledEventRepository;
    private final RecalculateCurrentScheduleUseCase recalculateCurrentScheduleUseCase;

    @Transactional
    public void createScheduledEvents(CreateScheduledEventsRequest request) {
        request.getScheduledEvents()
                .forEach(scheduleNewEventUseCase::execute);
        recalculateCurrentScheduleUseCase.execute();
    }

    public GetAllScheduledEventsResponse getAllScheduledEvents() {
        return new GetAllScheduledEventsResponse(
                getAllScheduledEventsUseCase.execute()
                        .stream()
                        .map(ScheduledEvent::toDTO)
                        .toList()
        );
    }

    public CreateScheduledEventsRequest createExportEventsJson() {
        var newScheduledEvents = scheduledEventRepository
                .findAll()
                .stream()
                .map(e -> new CreateScheduledEventsRequest.NewScheduledEvent(
                        e.getEventName(),
                        e.getEventDate(),
                        e.getStartTime(),
                        e.getDuration().toMinutes(),
                        e.getPriority(),
                        e.getMinPreferredStartTime(),
                        e.getMaxPreferredStartTime()
                ))
                .toList();
        return new CreateScheduledEventsRequest(newScheduledEvents);
    }
}
