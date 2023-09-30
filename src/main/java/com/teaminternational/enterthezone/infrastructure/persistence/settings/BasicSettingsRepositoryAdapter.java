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
                LocalDate.parse(all.get(BasicSettingsKey.TODAY_DATE.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.MONDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.MONDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.TUESDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.TUESDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.WEDNESDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.WEDNESDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.THURSDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.THURSDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.FRIDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.FRIDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.SATURDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.SATURDAY_END_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.SUNDAY_START_TIME.getId()).getValue()),
                LocalTime.parse(all.get(BasicSettingsKey.SUNDAY_END_TIME.getId()).getValue()),
                Boolean.parseBoolean(all.get(BasicSettingsKey.IGNORE_SATURDAY.getId()).getValue()),
                Boolean.parseBoolean(all.get(BasicSettingsKey.IGNORE_SUNDAY.getId()).getValue())
        );
    }
}
