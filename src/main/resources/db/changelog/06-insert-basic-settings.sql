--liquibase formatted sql
--changeset enter-the-zone:06-insert-basic-settings

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (2, 'MONDAY_START_TIME', '09:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (3, 'MONDAY_END_TIME', '17:00');

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (4, 'TUESDAY_START_TIME', '09:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (5, 'TUESDAY_END_TIME', '17:00');

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (6, 'WEDNESDAY_START_TIME', '09:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (7, 'WEDNESDAY_END_TIME', '17:00');

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (8, 'THURSDAY_START_TIME', '09:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (9, 'THURSDAY_END_TIME', '17:00');

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (10, 'FRIDAY_START_TIME', '09:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (11, 'FRIDAY_END_TIME', '17:00');

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (16, 'IGNORE_SATURDAY', 'true');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (17, 'IGNORE_SUNDAY', 'true');