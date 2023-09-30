package com.teaminternational.enterthezone.infrastructure.persistence.user;

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
@Table(name = "user_data", schema = "enter_the_zone")
@Entity
public class UserEntity {
    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
