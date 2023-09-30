--liquibase formatted sql
--changeset enter-the-zone:09-insert-basic-settings

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (18, 'LUNCH_TIME_WINDOW_START', '13:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (19, 'LUNCH_TIME_WINDOW_END', '15:00');
INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (20, 'LUNCH_DURATION', '45');