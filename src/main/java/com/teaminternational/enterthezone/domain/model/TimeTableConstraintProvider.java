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
                timeEntryConflict(constraintFactory)
        };
    }

    public Constraint timeEntryConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .join(
                        ScheduledEvent.class,
                        Joiners.lessThan(ScheduledEvent::getId),
                        Joiners.filtering((e1, e2) -> e2.getStartTime().startTime().isBefore(e1.getStartTime().startTime().plus(e1.getDuration())))
                        )
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("TimeEntry conflict");
    }
}
