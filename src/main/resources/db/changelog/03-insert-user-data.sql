--liquibase formatted sql
--changeset enter-the-zone:03-insert-user-data

INSERT INTO enter_the_zone.user_data (id, first_name, last_name) VALUES (1, 'Jan', 'Kowalski');
INSERT INTO enter_the_zone.user_data (id, first_name, last_name) VALUES (2, 'John', 'Doe');