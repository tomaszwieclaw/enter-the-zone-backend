package com.teaminternational.enterthezone.application.service;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventRequest;
import com.teaminternational.enterthezone.application.model.CreateScheduledEventResponse;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;
import com.teaminternational.enterthezone.domain.usecase.ScheduleNewEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduledEventApiService {
    private final ScheduleNewEventUseCase scheduleNewEventUseCase;

    public CreateScheduledEventResponse createScheduledEvent(CreateScheduledEventRequest request) {
        ScheduledEventDTO scheduledEvent = scheduleNewEventUseCase.execute(request);
        return new CreateScheduledEventResponse(
                scheduledEvent.id()
        );
    }
}
