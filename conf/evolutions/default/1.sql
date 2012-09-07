# Tasks schema

# --- !Ups

CREATE SEQUENCE task_id_seq;
CREATE TABLE TASK (
    ID integer NOT NULL DEFAULT nextval('task_id_seq'),
    LABEL varchar(255)
);

# --- !Downs

DROP TABLE task;
DROP SEQUENCE task_id_seq;