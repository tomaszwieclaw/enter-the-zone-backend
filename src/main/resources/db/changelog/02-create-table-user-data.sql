--liquibase formatted sql
--changeset enter-the-zone:02-create-table-user-data

CREATE TABLE enter_the_zone.user_data
(
    id         bigint PRIMARY KEY,
    first_name varchar(100),
    last_name  varchar(100) NOT NULL
);