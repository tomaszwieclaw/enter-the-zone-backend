package com.teaminternational.enterthezone.infrastructure.persistence.scheduledevent;

import com.teaminternational.enterthezone.domain.model.ScheduledEvent;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ScheduledEventEntityMapper {

    ScheduledEventEntity mapToDatabaseEntity(ScheduledEvent domainEntity) {
        return new ScheduledEventEntity(
                domainEntity.getId(),
                domainEntity.getEventName(),
                domainEntity.getDuration().toMinutes(),
                domainEntity.getEventDate(),
                domainEntity.getStartTime(),
                domainEntity.getPriority()
        );
    }

    ScheduledEvent mapToDomainEntity(ScheduledEventEntity databaseEntity) {
        return new ScheduledEvent(
                databaseEntity.getId(),
                databaseEntity.getEventName(),
                Duration.ofMinutes(databaseEntity.getDuration()),
                databaseEntity.getEventDate(),
                databaseEntity.getStartTime(),
                databaseEntity.getPriority()
        );
    }
}
