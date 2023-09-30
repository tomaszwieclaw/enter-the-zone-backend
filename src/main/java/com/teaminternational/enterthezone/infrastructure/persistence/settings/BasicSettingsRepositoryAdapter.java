package com.teaminternational.enterthezone.infrastructure.persistence.settings;

import com.teaminternational.enterthezone.domain.model.BasicSettings;
import com.teaminternational.enterthezone.domain.model.BasicSettingsKey;
import com.teaminternational.enterthezone.domain.repository.BasicSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.teaminternational.enterthezone.domain.model.BasicSettingsKey.*;

@RequiredArgsConstructor
@Repository
public class BasicSettingsRepositoryAdapter implements BasicSettingsRepository {
    private final BasicSettingsSpringDataRepository basicSettingsSpringDataRepository;

    @Override
    public BasicSettings findAll() {
        final Map<Long, BasicSettingsEntity> all = basicSettingsSpringDataRepository.findAll()
                .stream()
                .collect(Collectors.toMap(BasicSettingsEntity::getId, Function.identity()));
        return new BasicSettings(
                LocalDate.parse(all.get(TODAY_DATE.getId()).getValue()),
                LocalTime.parse(all.get(MONDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(MONDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(TUESDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(TUESDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(WEDNESDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(WEDNESDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(THURSDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(THURSDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(FRIDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(FRIDAY_END_TIME.getId()).getValue()),
                null,
                null,
                null,
                null,
                Boolean.parseBoolean(all.get(IGNORE_SATURDAY.getId()).getValue()),
                Boolean.parseBoolean(all.get(IGNORE_SUNDAY.getId()).getValue()),
                LocalTime.parse(all.get(LUNCH_TIME_WINDOW_START.getId()).getValue()),
                LocalTime.parse(all.get(LUNCH_TIME_WINDOW_END.getId()).getValue()),
                Long.parseLong(all.get(LUNCH_DURATION.getId()).getValue())
        );
    }

    @Override
    public void updateAll(BasicSettings basicSettings) {
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        TODAY_DATE.getId(),
                        TODAY_DATE.toString(),
                        basicSettings.getTodayDate().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        MONDAY_START_TIME.getId(),
                        MONDAY_START_TIME.toString(),
                        basicSettings.getMondayStartTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        MONDAY_END_TIME.getId(),
                        MONDAY_END_TIME.toString(),
                        basicSettings.getMondayEndTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        TUESDAY_START_TIME.getId(),
                        TUESDAY_START_TIME.toString(),
                        basicSettings.getTuesdayStartTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        TUESDAY_END_TIME.getId(),
                        TUESDAY_END_TIME.toString(),
                        basicSettings.getTuesdayEndTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        WEDNESDAY_START_TIME.getId(),
                        WEDNESDAY_START_TIME.toString(),
                        basicSettings.getWednesdayStartTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        WEDNESDAY_END_TIME.getId(),
                        WEDNESDAY_END_TIME.toString(),
                        basicSettings.getWednesdayEndTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        THURSDAY_START_TIME.getId(),
                        THURSDAY_START_TIME.toString(),
                        basicSettings.getThursdayStartTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        THURSDAY_END_TIME.getId(),
                        THURSDAY_END_TIME.toString(),
                        basicSettings.getThursdayEndTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        FRIDAY_START_TIME.getId(),
                        FRIDAY_START_TIME.toString(),
                        basicSettings.getFridayStartTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        FRIDAY_END_TIME.getId(),
                        FRIDAY_END_TIME.toString(),
                        basicSettings.getFridayEndTime().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        SATURDAY_START_TIME.getId(),
                        SATURDAY_START_TIME.toString(),
                        null)
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        SATURDAY_END_TIME.getId(),
                        SATURDAY_END_TIME.toString(),
                        null)
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        SUNDAY_START_TIME.getId(),
                        SUNDAY_START_TIME.toString(),
                        null)
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        SUNDAY_END_TIME.getId(),
                        SUNDAY_END_TIME.toString(),
                        null)
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        IGNORE_SATURDAY.getId(),
                        IGNORE_SATURDAY.toString(),
                        String.valueOf(basicSettings.isIgnoreSaturday()))
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        IGNORE_SUNDAY.getId(),
                        IGNORE_SUNDAY.toString(),
                        String.valueOf(basicSettings.isIgnoreSunday()))
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        LUNCH_TIME_WINDOW_START.getId(),
                        LUNCH_TIME_WINDOW_START.toString(),
                        basicSettings.getPreferredLunchTimeWindowStart().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        LUNCH_TIME_WINDOW_END.getId(),
                        LUNCH_TIME_WINDOW_END.toString(),
                        basicSettings.getPreferredLunchTimeWindowEnd().toString())
        );
        basicSettingsSpringDataRepository.saveAndFlush(
                new BasicSettingsEntity(
                        LUNCH_DURATION.getId(),
                        LUNCH_DURATION.toString(),
                        String.valueOf(basicSettings.getLunchTimeDurationMinutes()))
        );
    }
}
