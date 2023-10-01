package com.teaminternational.enterthezone.domain.model;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TimeEntriesProvider {

    public List<LocalTime> getAvailableTimeEntries(EventType eventType, LocalTime startTime) {
        if (EventType.FIXED_MEETING == eventType) {
            return Collections.singletonList(startTime);
        } else {
            return workingHours();
        }
    }

    private List<LocalTime> workingHours() {
        List<LocalTime> timeEntries = new ArrayList<>();
        LocalTime dayStartsAt = LocalTime.of(9, 0);
        timeEntries.add(dayStartsAt);
        LocalTime nextSlotStartsAt = dayStartsAt.plus(TimeTable.DEFAULT_DURATION);
        while (nextSlotStartsAt.isBefore(LocalTime.of(17, 1))) {
            timeEntries.add(nextSlotStartsAt);
            nextSlotStartsAt = nextSlotStartsAt.plus(TimeTable.DEFAULT_DURATION);
        }
        return timeEntries;
    }
}
