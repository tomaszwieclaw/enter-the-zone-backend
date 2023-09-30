package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.usecase.RecalculateCurrentScheduleUseCase;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RecalculateCurrentScheduleService implements RecalculateCurrentScheduleUseCase {

    @Async
    @Override
    public void execute() {

    }
}
