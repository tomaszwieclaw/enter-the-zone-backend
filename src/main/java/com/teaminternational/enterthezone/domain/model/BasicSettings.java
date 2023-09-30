package com.teaminternational.enterthezone.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
public class BasicSettings {
    private LocalDate todayDate;
    private LocalTime mondayStartTime;
    private LocalTime mondayEndTime;
    private LocalTime tuesdayStartTime;
    private LocalTime tuesdayEndTime;
    private LocalTime wednesdayStartTime;
    private LocalTime wednesdayEndTime;
    private LocalTime thursdayStartTime;
    private LocalTime thursdayEndTime;
    private LocalTime fridayStartTime;
    private LocalTime fridayEndTime;
    private LocalTime saturdayStartTime;
    private LocalTime saturdayEndTime;
    private LocalTime sundayStartTime;
    private LocalTime sundayEndTime;
    private boolean ignoreSaturday;
    private boolean ignoreSunday;
    private LocalTime preferredLunchTimeWindowStart;
    private LocalTime preferredLunchTimeWindowEnd;
    private long lunchTimeDurationMinutes;
}
