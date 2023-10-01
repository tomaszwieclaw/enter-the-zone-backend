package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;

import java.util.List;

public interface GenerateTaskEventsUseCase {

    List<ScheduledEvent> execute();
}
