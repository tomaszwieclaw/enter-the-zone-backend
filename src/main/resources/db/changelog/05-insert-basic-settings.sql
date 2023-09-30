--liquibase formatted sql
--changeset enter-the-zone:05-insert-basic-settings

INSERT INTO enter_the_zone.basic_settings (id, key, value) VALUES (1, 'TODAY_DATE', '2023-10-02');