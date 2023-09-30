--liquibase formatted sql
--changeset enter-the-zone:07-create-table-scheduled-event

CREATE TABLE enter_the_zone.scheduled_event
(
    id        uuid PRIMARY KEY,
    event_name varchar(250) NOT NULL,
    duration  integer,
    event_date date,
    start_time time,
    priority  varchar(50)
);