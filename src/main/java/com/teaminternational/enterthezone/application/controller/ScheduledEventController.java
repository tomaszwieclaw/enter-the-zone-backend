package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventRequest;
import com.teaminternational.enterthezone.application.model.CreateScheduledEventResponse;
import com.teaminternational.enterthezone.application.service.ScheduledEventApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/scheduled-events")
@RestController
public class ScheduledEventController {
    private final ScheduledEventApiService scheduledEventApiService;

    @PostMapping
    public CreateScheduledEventResponse createScheduledEvent(@RequestBody CreateScheduledEventRequest request) {
        return scheduledEventApiService.createScheduledEvent(request);
    }
}
