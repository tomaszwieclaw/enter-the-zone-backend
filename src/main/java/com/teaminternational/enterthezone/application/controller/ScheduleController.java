package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.application.model.GetCurrentScheduleStatusResponse;
import com.teaminternational.enterthezone.application.service.ScheduleApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {
    private final ScheduleApiService scheduleApiService;

    @GetMapping
    public GetCurrentScheduleResponse getCurrentSchedule() {
        return scheduleApiService.getCurrentSchedule();
    }

    @GetMapping
    public GetCurrentScheduleStatusResponse getCurrentScheduleStatus() {
        return scheduleApiService.getCurrentScheduleStatus();
    }
}
