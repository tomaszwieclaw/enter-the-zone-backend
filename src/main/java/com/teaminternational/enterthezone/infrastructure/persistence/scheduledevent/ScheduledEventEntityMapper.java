package com.teaminternational.enterthezone.infrastructure.persistence.scheduledevent;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import com.teaminternational.enterthezone.domain.model.TimeEntriesProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@RequiredArgsConstructor
@Component
public class ScheduledEventEntityMapper {
    private final TimeEntriesProvider timeEntriesProvider;

    ScheduledEventEntity mapToDatabaseEntity(ScheduledEvent domainEntity) {
        return new ScheduledEventEntity(
                domainEntity.getId(),
                domainEntity.getEventName(),
                domainEntity.getEventType(),
                domainEntity.getDuration().toMinutes(),
                domainEntity.getEventDate(),
                domainEntity.getStartTime(),
                domainEntity.getPriority(),
                domainEntity.getMinPreferredStartTime(),
                domainEntity.getMaxPreferredStartTime()
        );
    }

    ScheduledEvent mapToDomainEntity(ScheduledEventEntity databaseEntity) {
        return new ScheduledEvent(
                databaseEntity.getId(),
                databaseEntity.getEventName(),
                databaseEntity.getEventType(),
                Duration.ofMinutes(databaseEntity.getDuration()),
                databaseEntity.getEventDate(),
                databaseEntity.getStartTime(),
                timeEntriesProvider.getAvailableTimeEntries(databaseEntity.getEventType(), databaseEntity.getStartTime()),
                databaseEntity.getPriority(),
                databaseEntity.getMinPreferredStartTime(),
                databaseEntity.getMaxPreferredStartTime()
        );
    }
}
