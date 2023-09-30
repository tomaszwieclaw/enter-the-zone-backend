package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.application.service.GetCurrentScheduleApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {
    private final GetCurrentScheduleApiService getCurrentScheduleApiService;

    @GetMapping
    public GetCurrentScheduleResponse getCurrentSchedule() {
        return getCurrentScheduleApiService.getCurrentSchedule();
    }
}
