package com.teaminternational.enterthezone.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record BasicSettings(
        LocalDate todayDate,
        LocalTime mondayStartTime,
        LocalTime mondayEndTime,
        LocalTime tuesdayStartTime,
        LocalTime tuesdayEndTime,
        LocalTime wednesdayStartTime,
        LocalTime wednesdayEndTime,
        LocalTime thursdayStartTime,
        LocalTime thursdayEndTime,
        LocalTime fridayStartTime,
        LocalTime fridayEndTime,
        LocalTime saturdayStartTime,
        LocalTime saturdayEndTime,
        LocalTime sundayStartTime,
        LocalTime sundayEndTime,
        boolean ignoreSaturday,
        boolean ignoreSunday
) {
}
