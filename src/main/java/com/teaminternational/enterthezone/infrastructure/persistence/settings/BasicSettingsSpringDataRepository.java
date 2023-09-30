package com.teaminternational.enterthezone.infrastructure.persistence.settings;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicSettingsSpringDataRepository extends JpaRepository<BasicSettingsEntity, Long> {
}
