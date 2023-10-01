package com.teaminternational.enterthezone.application.service;

import com.teaminternational.enterthezone.application.model.GetCurrentScheduleResponse;
import com.teaminternational.enterthezone.application.model.GetCurrentScheduleStatusResponse;
import com.teaminternational.enterthezone.domain.model.TimeTableStatus;
import com.teaminternational.enterthezone.domain.usecase.GetCurrentScheduleUseCase;
import com.teaminternational.enterthezone.domain.usecase.RecalculateCurrentScheduleUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduleApiService {
    private final RecalculateCurrentScheduleUseCase recalculateCurrentScheduleUseCase;
    private final GetCurrentScheduleUseCase getCurrentScheduleUseCase;

    public GetCurrentScheduleResponse getCurrentSchedule() {
        return getCurrentScheduleUseCase.execute();
    }

    public GetCurrentScheduleStatusResponse getCurrentScheduleStatus() {
        return new GetCurrentScheduleStatusResponse(
                TimeTableStatus.UP_TO_DATE
        );
    }

    @Transactional
    public void recalculateScheduleOnDemand() {
        recalculateCurrentScheduleUseCase.execute();
    }
}
