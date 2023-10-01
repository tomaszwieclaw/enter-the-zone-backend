--liquibase formatted sql
--changeset enter-the-zone:10-create-table-planned-day

CREATE TABLE enter_the_zone.planned_day
(
    id                 uuid PRIMARY KEY,
    day_date           date,
    workday_start_time time,
    workday_end_time   time
);