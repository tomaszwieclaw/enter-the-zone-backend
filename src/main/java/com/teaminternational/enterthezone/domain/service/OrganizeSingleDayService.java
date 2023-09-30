package com.teaminternational.enterthezone.domain.service;

import com.teaminternational.enterthezone.domain.model.TimeTable;
import com.teaminternational.enterthezone.domain.usecase.OrganizeSingleDayUseCase;
import lombok.RequiredArgsConstructor;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
public class OrganizeSingleDayService implements OrganizeSingleDayUseCase {
    private final SolverManager<TimeTable, UUID> solverManager;

    @Override
    public TimeTable execute(TimeTable problem) {
        SolverJob<TimeTable, UUID> solverJob = solverManager.solve(UUID.randomUUID(), problem);
        TimeTable solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }
}
