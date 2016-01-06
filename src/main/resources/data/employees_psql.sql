
-- Таблица departments
CREATE TABLE departments(
	department_id BIGSERIAL NOT NULL PRIMARY KEY,
	department_name CHARACTER(30) NOT NULL,
	manager_id NUMERIC(6) UNIQUE,
	location_id NUMERIC(4) UNIQUE
);
CREATE UNIQUE INDEX dept_id_pk ON departments (department_id);
CREATE SEQUENCE departments_seq
  INCREMENT BY 10
  MAXVALUE 9990
  START WITH 280
  NO CYCLE;

-- Таблица employees

CREATE TABLE employees(
	employee_id INTEGER PRIMARY KEY,
	first_name CHARACTER(20) NOT NULL,
	last_name VARCHAR(25) NOT NULL,
	email VARCHAR(25) NOT NULL,
	phone_number VARCHAR(20),
	hire_date DATE NOT NULL,
	job_id VARCHAR(10) NOT NULL,
	salary NUMERIC(8,2),
	commission_pct NUMERIC(2,2),
	manager_id NUMERIC(6),
	department_id INTEGER REFERENCES departments (department_id),
	CONSTRAINT emp_salary_min CHECK (salary > 0),
	CONSTRAINT emp_email_uk UNIQUE (email)
);

SELECT NEXTVAL('departments_seq');
INSERT INTO departments(department_id, department_name, manager_id, location_id) VALUES (0, currval('departments_seq'),0,0);
INSERT INTO departments(department_id, department_name, manager_id, location_id) VALUES (481, 'Sales', 1,1);
UPDATE departments SET department_id=300 WHERE department_name='300';
UPDATE departments SET department_name='IT' WHERE department_id=300;
INSERT INTO employees VALUES(0, 'Ирина Николаевна', 'Василькова', 'vasilkova@test', '+3(423)332-31-12', current_timestamp, 0, 1, 0.23, 0,300);
INSERT INTO employees VALUES(1, 'Кирилл Петрович', 'Шниперсон', 'snippersonchik_a@test', '+3(423)332-31-12', current_timestamp, 0, 1, 0.23, 0,300);
INSERT INTO employees VALUES(2, 'Валентина', 'Касикова', 'kasilkiva@test', '+3(423)332-31-13', current_timestamp, 0, 1, 0.23, 0,300);
INSERT INTO employees VALUES(3, 'Оксана', 'Продавшкина','prodovashkina@test', '+3(423)332-33-33', current_timestamp, 0, 1, 0.23, 0,481);
INSERT INTO employees VALUES(4, 'Максим', 'Шубин', 'shubin@test', '+3(423)332-44-44', current_timestamp, 0, 1, 0.23, 0,481);

alter table employees ADD  FOREIGN KEY(department_id) references departments;
