package com.teaminternational.enterthezone.infrastructure.persistence.settings;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "basic_settings", schema = "enter_the_zone")
@Entity
public class BasicSettingsEntity {
    @Id
    private Long id;

    private String key;

    private String value;
}
