package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventRequest;
import com.teaminternational.enterthezone.application.model.CreateScheduledEventResponse;
import com.teaminternational.enterthezone.application.model.GetAllScheduledEventsResponse;
import com.teaminternational.enterthezone.application.service.ScheduledEventApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/scheduled-events")
@RestController
public class ScheduledEventController {
    private final ScheduledEventApiService scheduledEventApiService;

    @PostMapping
    public CreateScheduledEventResponse createScheduledEvent(@RequestBody CreateScheduledEventRequest request) {
        return scheduledEventApiService.createScheduledEvent(request);
    }

    @GetMapping
    public GetAllScheduledEventsResponse getAllScheduledEvents() {
        return scheduledEventApiService.getAllScheduledEvents();
    }
}
