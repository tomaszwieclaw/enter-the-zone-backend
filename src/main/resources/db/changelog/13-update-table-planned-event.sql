--liquibase formatted sql
--changeset enter-the-zone:13-update-table-planned-event

ALTER TABLE enter_the_zone.planned_event
    ADD COLUMN event_type varchar(50);