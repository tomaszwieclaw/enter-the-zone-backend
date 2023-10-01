package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventsRequest;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;

public interface ScheduleNewEventUseCase {

    ScheduledEventDTO execute(CreateScheduledEventsRequest.NewScheduledEvent newScheduledEvent);
}
