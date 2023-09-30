package com.teaminternational.enterthezone.domain.model;

import java.time.Duration;
import java.time.LocalTime;

public record TimeEntry(
        LocalTime startTime
) {

    public static final Duration DEFAULT_DURATION = Duration.ofMinutes(15);

    public static final TimeEntry of(LocalTime localTime) {
        return new TimeEntry(localTime);
    }
}
