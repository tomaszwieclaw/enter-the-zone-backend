package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.application.model.GetCurrentScheduleStatusResponse;
import com.teaminternational.enterthezone.application.service.ScheduleApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController {
    private final ScheduleApiService scheduleApiService;

    @GetMapping
    public GetCurrentScheduleResponse getCurrentSchedule() {
        return scheduleApiService.getCurrentSchedule();
    }

    @RequestMapping("/status")
    @GetMapping
    public GetCurrentScheduleStatusResponse getCurrentScheduleStatus() {
        return scheduleApiService.getCurrentScheduleStatus();
    }

    @PostMapping("/recalculate")
    public void recalculateScheduleOnDemand() {
        scheduleApiService.recalculateScheduleOnDemand();
    }
}
