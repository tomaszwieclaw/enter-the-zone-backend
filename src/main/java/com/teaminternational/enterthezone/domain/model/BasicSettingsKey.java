package com.teaminternational.enterthezone.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasicSettingsKey {
    TODAY_DATE(1L),
    MONDAY_START_TIME(2L),
    MONDAY_END_TIME(3L),
    TUESDAY_START_TIME(4L),
    TUESDAY_END_TIME(5L),
    WEDNESDAY_START_TIME(6L),
    WEDNESDAY_END_TIME(7L),
    THURSDAY_START_TIME(8L),
    THURSDAY_END_TIME(9L),
    FRIDAY_START_TIME(10L),
    FRIDAY_END_TIME(11L),
    SATURDAY_START_TIME(12L),
    SATURDAY_END_TIME(13L),
    SUNDAY_START_TIME(14L),
    SUNDAY_END_TIME(15L),
    IGNORE_SATURDAY(16L),
    IGNORE_SUNDAY(17L),
    LUNCH_TIME_WINDOW_START(18L),
    LUNCH_TIME_WINDOW_END(19L),
    LUNCH_DURATION(20L);

    private final Long id;
}
