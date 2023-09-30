--liquibase formatted sql
--changeset enter-the-zone:04-create-table-basic-settings

CREATE TABLE enter_the_zone.basic_settings
(
    id    bigint PRIMARY KEY,
    key   varchar(100) NOT NULL,
    value varchar(100)
);