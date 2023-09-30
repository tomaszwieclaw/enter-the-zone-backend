package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.application.model.UpdateGeneralSettingsRequest;
import com.teaminternational.enterthezone.domain.model.BasicSettings;
import com.teaminternational.enterthezone.domain.repository.BasicSettingsRepository;
import com.teaminternational.enterthezone.domain.usecase.UpdateGeneralSettingsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateGeneralSettingsService implements UpdateGeneralSettingsUseCase {
    private final BasicSettingsRepository basicSettingsRepository;

    @Override
    public void execute(UpdateGeneralSettingsRequest request) {
        BasicSettings allSettings = basicSettingsRepository.findAll();
        allSettings.setMondayStartTime(request.workingDayStartTime());
        allSettings.setTuesdayStartTime(request.workingDayStartTime());
        allSettings.setWednesdayStartTime(request.workingDayStartTime());
        allSettings.setThursdayStartTime(request.workingDayStartTime());
        allSettings.setFridayStartTime(request.workingDayStartTime());

        allSettings.setMondayEndTime(request.workingDayEndTime());
        allSettings.setTuesdayEndTime(request.workingDayEndTime());
        allSettings.setWednesdayEndTime(request.workingDayEndTime());
        allSettings.setThursdayEndTime(request.workingDayEndTime());
        allSettings.setFridayEndTime(request.workingDayEndTime());

        allSettings.setLunchTimeDurationMinutes(request.lunchTimeDurationMinutes());
        allSettings.setPreferredLunchTimeWindowStart(request.preferredLunchTimeWindowStart());
        allSettings.setPreferredLunchTimeWindowEnd(request.preferredLunchTimeWindowEnd());

        basicSettingsRepository.updateAll(allSettings);
    }
}
