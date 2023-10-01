package com.teaminternational.enterthezone.application.controller;

import com.teaminternational.enterthezone.application.model.UpdateGeneralSettingsRequest;
import com.teaminternational.enterthezone.application.service.UserSettingsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user-settings")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserSettingsController {
    private final UserSettingsApiService userSettingsApiService;

    @PutMapping("/general")
    public void updateGeneralSettings(@RequestBody UpdateGeneralSettingsRequest request) {
        userSettingsApiService.updateGeneralSettings(request);
    }
}
