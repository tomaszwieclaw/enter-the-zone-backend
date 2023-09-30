package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.model.TimeEntry;
import com.teaminternational.enterthezone.domain.model.TimeTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrganizeSingleDayUseCaseTest {

    @Autowired
    OrganizeSingleDayUseCase sut;

    @Test
    void test() {
        //given
        var problem = new TimeTable(
                workingHours(),
                workingDayEvents()
        );
        //when
        TimeTable result = sut.execute(problem);
        //then
        result
                .getScheduledEvents()
                .forEach(System.out::println);
    }

    private List<TimeEntry> workingHours() {
        List<TimeEntry> timeEntries = new ArrayList<>();
        LocalTime dayStartsAt = LocalTime.of(9, 0);
        timeEntries.add(TimeEntry.of(dayStartsAt));
        LocalTime nextSlotStartsAt = dayStartsAt.plus(TimeEntry.DEFAULT_DURATION);
        while (nextSlotStartsAt.isBefore(LocalTime.of(17, 1))) {
            timeEntries.add(TimeEntry.of(nextSlotStartsAt));
            nextSlotStartsAt = nextSlotStartsAt.plus(TimeEntry.DEFAULT_DURATION);
        }
        return timeEntries;
    }

    private List<ScheduledEvent> workingDayEvents() {
        return List.of(
                new ScheduledEvent(
                        1L,
                        "Daily Meeting",
                        TimeEntry.DEFAULT_DURATION.multipliedBy(1)
                ),
                new ScheduledEvent(
                        2L,
                        "Tech Interview",
                        TimeEntry.DEFAULT_DURATION.multipliedBy(6)
                ),
                new ScheduledEvent(
                        3L,
                        "In the zone (1)",
                        TimeEntry.DEFAULT_DURATION.multipliedBy(3)
                ),
                new ScheduledEvent(
                        4L,
                        "In the zone (2)",
                        TimeEntry.DEFAULT_DURATION.multipliedBy(3)
                ),
                new ScheduledEvent(
                        5L,
                        "In the zone (3)",
                        TimeEntry.DEFAULT_DURATION.multipliedBy(3)
                )
        );
    }
}