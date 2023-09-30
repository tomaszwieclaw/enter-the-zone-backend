--liquibase formatted sql
--changeset enter-the-zone:08-update-table-scheduled-event

ALTER TABLE enter_the_zone.scheduled_event
    ADD COLUMN min_preferred_start_time time;

ALTER TABLE enter_the_zone.scheduled_event
    ADD COLUMN max_preferred_start_time time;