--liquibase formatted sql
--changeset enter-the-zone:11-create-table-planned-event

CREATE TABLE enter_the_zone.planned_event
(
    id                       uuid PRIMARY KEY,
    planned_day_id           uuid         NOT NULL,
    event_id                 uuid         NOT NULL,
    event_date               date         NOT NULL,
    event_name               varchar(250) NOT NULL,
    start_time               time,
    end_time                 time,
    total_duration_min       bigint,
    priority                 varchar(50),
    min_preferred_start_time time,
    max_preferred_start_time time
);