package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventRequest;
import com.teaminternational.enterthezone.domain.model.ScheduledEventDTO;

public interface ScheduleNewEventUseCase {

    ScheduledEventDTO execute(CreateScheduledEventRequest request);
}
