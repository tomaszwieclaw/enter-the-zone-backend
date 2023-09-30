package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.domain.model.TimeTable;

public interface OrganizeSingleDayUseCase {

    TimeTable execute(TimeTable timeTable);
}
