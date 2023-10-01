package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.application.model.GetCurrentScheduleStatusResponse;
import com.teaminternational.enterthezone.application.service.ScheduleApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {
    private final ScheduleApiService scheduleApiService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public GetCurrentScheduleResponse getCurrentSchedule() {
        return scheduleApiService.getCurrentSchedule();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/status")
    @GetMapping
    public GetCurrentScheduleStatusResponse getCurrentScheduleStatus() {
        return scheduleApiService.getCurrentScheduleStatus();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/recalculate")
    public void recalculateScheduleOnDemand() {
        scheduleApiService.recalculateScheduleOnDemand();
    }
}
