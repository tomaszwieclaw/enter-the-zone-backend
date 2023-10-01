--liquibase formatted sql
--changeset enter-the-zone:12-update-table-scheduled-event

ALTER TABLE enter_the_zone.scheduled_event
    ADD COLUMN event_type varchar(50);