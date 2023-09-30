package com.teaminternational.enterthezone.domain.usecase;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
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

    private List<ScheduledEvent> workingDayEvents() {
        var dailyMeeting = new ScheduledEvent(
                1L,
                "Daily Meeting",
                TimeTable.DEFAULT_DURATION.multipliedBy(1)
        );
        var techInterview = new ScheduledEvent(
                2L,
                "Tech Interview",
                TimeTable.DEFAULT_DURATION.multipliedBy(6)
        );
        techInterview.setStartTime(LocalTime.of(12, 0));
        dailyMeeting.setStartTime(LocalTime.of(9, 15));
        return List.of(
                dailyMeeting,
                techInterview,
                new ScheduledEvent(
                        3L,
                        "In the zone (1)",
                        TimeTable.DEFAULT_DURATION.multipliedBy(3)
                ),
                new ScheduledEvent(
                        4L,
                        "In the zone (2)",
                        TimeTable.DEFAULT_DURATION.multipliedBy(3)
                ),
                new ScheduledEvent(
                        5L,
                        "In the zone (3)",
                        TimeTable.DEFAULT_DURATION.multipliedBy(3)
                )
        );
    }
}