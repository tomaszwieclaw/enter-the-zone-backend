package com.teaminternational.enterthezone.application.service;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventRequest;
import com.teaminternational.enterthezone.application.model.CreateScheduledEventResponse;
import com.teaminternational.enterthezone.application.model.GetAllScheduledEventsResponse;
import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;
import com.teaminternational.enterthezone.domain.usecase.GetAllScheduledEventsUseCase;
import com.teaminternational.enterthezone.domain.usecase.ScheduleNewEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduledEventApiService {
    private final ScheduleNewEventUseCase scheduleNewEventUseCase;
    private final GetAllScheduledEventsUseCase getAllScheduledEventsUseCase;

    public CreateScheduledEventResponse createScheduledEvent(CreateScheduledEventRequest request) {
        ScheduledEventDTO scheduledEvent = scheduleNewEventUseCase.execute(request);
        return new CreateScheduledEventResponse(
                scheduledEvent.id()
        );
    }

    public GetAllScheduledEventsResponse getAllScheduledEvents() {
        return new GetAllScheduledEventsResponse(
                getAllScheduledEventsUseCase.execute()
                        .stream()
                        .map(ScheduledEvent::toDTO)
                        .toList()
        );
    }
}
