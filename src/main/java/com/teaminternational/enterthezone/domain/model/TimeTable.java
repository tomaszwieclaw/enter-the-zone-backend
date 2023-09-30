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

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@PlanningSolution
public class TimeTable {
    public static final Duration DEFAULT_DURATION = Duration.ofMinutes(15);

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<LocalTime> timeEntries;

    @PlanningEntityCollectionProperty
    private List<ScheduledEvent> scheduledEvents;

    @PlanningScore
    private HardSoftScore score;

    public TimeTable(
            List<LocalTime> timeEntries,
            List<ScheduledEvent> scheduledEvents
    ) {
        this.timeEntries = timeEntries;
        this.scheduledEvents = scheduledEvents;
    }
}
