package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;

import java.time.LocalDate;
import java.util.List;

public interface GenerateInTheZoneEventsUseCase {

    List<ScheduledEvent> execute(LocalDate date);
}
