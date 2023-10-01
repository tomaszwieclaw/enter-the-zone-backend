package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.CreateScheduledEventsRequest;
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
    public void createScheduledEvents(@RequestBody CreateScheduledEventsRequest request) {
        scheduledEventApiService.createScheduledEvents(request);
    }

    @GetMapping
    public GetAllScheduledEventsResponse getAllScheduledEvents() {
        return scheduledEventApiService.getAllScheduledEvents();
    }

    @PostMapping("/export")
    public CreateScheduledEventsRequest createExportEventsJson() {
        return scheduledEventApiService.createExportEventsJson();
    }
}
