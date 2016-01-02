-- Table: departments

-- DROP TABLE departments;

CREATE TABLE departments
(
      department_id bigserial NOT NULL,
      department_name character(30) NOT NULL,
      manager_id numeric(6,0),
      location_id numeric(4,0),
      CONSTRAINT departments_pkey PRIMARY KEY (department_id),
      CONSTRAINT departments_location_id_key UNIQUE (location_id),
      CONSTRAINT departments_manager_id_key UNIQUE (manager_id)
)
WITH (
      OIDS=FALSE
);
ALTER TABLE departments
  OWNER TO restadmin01;

-- Index: dept_id_pk

-- DROP INDEX dept_id_pk;

CREATE UNIQUE INDEX dept_id_pk
  ON departments
  USING btree
  (department_id);

  


