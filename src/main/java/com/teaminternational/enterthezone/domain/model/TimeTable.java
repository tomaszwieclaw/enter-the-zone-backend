package com.teaminternational.enterthezone.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@PlanningSolution
public class TimeTable {

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<TimeEntry> timeEntries;

    @PlanningEntityCollectionProperty
    private List<ScheduledEvent> scheduledEvents;

    @PlanningScore
    private HardSoftScore score;

    public TimeTable(
            List<TimeEntry> timeEntries,
            List<ScheduledEvent> scheduledEvents
    ) {
        this.timeEntries = timeEntries;
        this.scheduledEvents = scheduledEvents;
    }
}
