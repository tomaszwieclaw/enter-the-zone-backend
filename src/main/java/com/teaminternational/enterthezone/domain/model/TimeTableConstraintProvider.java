package com.teaminternational.enterthezone.domain.model;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                timeEntryConflict(constraintFactory),
                preferredTimeWindow(constraintFactory)
        };
    }

    public Constraint timeEntryConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .join(
                        ScheduledEvent.class,
                        Joiners.filtering((e1, e2) -> e2.getStartTime().isBefore(e1.getStartTime().plus(e1.getDuration())))
                )
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("TimeEntry conflict");
    }

    public Constraint preferredTimeWindow(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .filter(scheduledEvent -> {
                    if (scheduledEvent.getMinPreferredStartTime() != null
                            && scheduledEvent.getMaxPreferredStartTime() != null) {
                        return scheduledEvent.getStartTime().isBefore(scheduledEvent.getMinPreferredStartTime())
                                || scheduledEvent.getStartTime().plus(scheduledEvent.getDuration()).isAfter(scheduledEvent.getMaxPreferredStartTime());
                    }
                    return false;
                })
                .penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("Preferred Time Window");
    }
}
