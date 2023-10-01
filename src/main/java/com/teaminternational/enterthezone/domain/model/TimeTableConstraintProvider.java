package com.teaminternational.enterthezone.domain.model;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

import java.time.Duration;
import java.time.LocalTime;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                timeEntryConflict(constraintFactory),
                outOfWorkingHoursConflict(constraintFactory),
                preferredTimeWindow(constraintFactory),
                suggestedBreakTimeBetweenInTheZoneMeetings(constraintFactory),
                suggestedBreakTimeAfterInTheZoneMeeting(constraintFactory),
                promoteFixedMeetings(constraintFactory)
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

    public Constraint outOfWorkingHoursConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .filter(e -> e.getStartTime().isBefore(LocalTime.of(9, 0)))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Out of working hours conflict");
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

    public Constraint suggestedBreakTimeBetweenInTheZoneMeetings(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .join(
                        ScheduledEvent.class,
                        Joiners.filtering((e1, e2) -> e1.getEventType() == EventType.IN_THE_ZONE && e2.getEventType() == EventType.IN_THE_ZONE),
                        Joiners.filtering((e1, e2) -> e1.getStartTime().isBefore(e2.getStartTime())),
                        Joiners.filtering((e1, e2) -> Duration.between(e1.getStartTime().plus(e1.getDuration()), e2.getStartTime()).toMinutes() < 30)
                ).penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("Between The Zone Break Time");
    }

    public Constraint suggestedBreakTimeAfterInTheZoneMeeting(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .join(
                        ScheduledEvent.class,
                        Joiners.filtering((e1, e2) -> e1.getEventType() == EventType.IN_THE_ZONE && e2.getEventType() != EventType.IN_THE_ZONE),
                        Joiners.filtering((e1, e2) -> e1.getStartTime().isBefore(e2.getStartTime())),
                        Joiners.filtering((e1, e2) -> Duration.between(e1.getStartTime().plus(e1.getDuration()), e2.getStartTime()).toMinutes() < 15)
                ).penalize(HardSoftScore.ONE_SOFT)
                .asConstraint("After The Zone Break Time");
    }

    public Constraint promoteFixedMeetings(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .filter(e -> e.getEventType() == EventType.FIXED_MEETING)
                .reward(HardSoftScore.ONE_HARD)
                .asConstraint("Promote fixed time meetings");
    }

    public Constraint skipFixedMeetings(ConstraintFactory constraintFactory) {
        return constraintFactory
                .forEach(ScheduledEvent.class)
                .filter(e -> e.getEventType() == EventType.FIXED_MEETING)
                .reward(HardSoftScore.ONE_HARD)
                .asConstraint("Promote fixed time meetings");
    }
}
