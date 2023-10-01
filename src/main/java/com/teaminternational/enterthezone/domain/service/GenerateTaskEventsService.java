package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.GenerateTaskEventsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenerateTaskEventsService implements GenerateTaskEventsUseCase {
    private final ScheduledEventRepository scheduledEventRepository;

    @Override
    public List<ScheduledEvent> execute() {
        return scheduledEventRepository.findAllFloatingTasks();
    }
}
