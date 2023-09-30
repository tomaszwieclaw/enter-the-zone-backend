package com.teaminternational.enterthezone.application.model;

import java.time.LocalTime;

public record UpdateGeneralSettingsRequest(
        LocalTime preferredLunchTimeWindowStart,
        LocalTime preferredLunchTimeWindowEnd,
        int lunchTimeDurationMinutes,
        LocalTime workingDayStartTime,
        LocalTime workingDayEndTime
) {
}
