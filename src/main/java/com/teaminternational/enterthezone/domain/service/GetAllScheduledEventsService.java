package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.repository.ScheduledEventRepository;
import com.teaminternational.enterthezone.domain.usecase.GetAllScheduledEventsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllScheduledEventsService implements GetAllScheduledEventsUseCase {
    private final ScheduledEventRepository scheduledEventRepository;

    @Override
    public List<ScheduledEvent> execute() {
        return scheduledEventRepository.findAll();
    }
}
