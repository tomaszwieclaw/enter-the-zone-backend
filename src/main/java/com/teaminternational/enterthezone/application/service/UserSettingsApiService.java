package com.teaminternational.enterthezone.application.service;

import com.teaminternational.enterthezone.application.model.UpdateGeneralSettingsRequest;
import com.teaminternational.enterthezone.domain.usecase.UpdateGeneralSettingsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSettingsApiService {
    private final UpdateGeneralSettingsUseCase updateGeneralSettingsUseCase;

    public void updateGeneralSettings(UpdateGeneralSettingsRequest request) {
        updateGeneralSettingsUseCase.execute(request);
    }
}
