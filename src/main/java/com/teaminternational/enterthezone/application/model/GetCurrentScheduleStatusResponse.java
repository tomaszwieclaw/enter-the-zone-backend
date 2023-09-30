package com.teaminternational.enterthezone.application.model;

import com.teaminternational.enterthezone.domain.model.TimeTableStatus;

public record GetCurrentScheduleStatusResponse(
        TimeTableStatus status
) {
}
