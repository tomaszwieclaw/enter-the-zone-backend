package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.UpdateGeneralSettingsRequest;
import com.teaminternational.enterthezone.application.service.UserSettingsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/user-settings")
@RestController
public class UserSettingsController {
    private final UserSettingsApiService userSettingsApiService;

    @PutMapping("/general")
    public void updateGeneralSettings(@RequestBody UpdateGeneralSettingsRequest request) {
        userSettingsApiService.updateGeneralSettings(request);
    }
}
