package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;

import java.time.LocalDate;

public interface GenerateLunchTimeEventUseCase {

    ScheduledEvent execute(LocalDate date);
}
