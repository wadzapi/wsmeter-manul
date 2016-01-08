--DROP TABLE departments;
--DROP SEQUENCE departments_seq;
--DROP TABLE employees;

-- Таблица departments
CREATE SEQUENCE departments_seq
  START WITH 280
  INCREMENT BY 10
  MAXVALUE 9990
  NO CYCLE;


CREATE TABLE departments(
	department_id BIGINT DEFAULT departments_seq.nextval PRIMARY KEY,
	department_name VARCHAR(30) UNIQUE NOT NULL,
	manager_id INT,
	location_id INT
);

---- Таблица employees
CREATE TABLE employees
   (employee_id IDENTITY PRIMARY KEY
   , first_name VARCHAR(20)
   , last_name VARCHAR(25) NOT NULL
   , email VARCHAR NOT NULL
   , phone_number VARCHAR(20)
   , hire_date DATE NOT NULL
   , job_id VARCHAR(10) NOT NULL
   , salary DECIMAL(8,2)
   , commission_pct DECIMAL(2,2)
   , manager_id INT
   , department_id BIGINT
   , FOREIGN KEY(department_id) REFERENCES departments(department_id)
   , CONSTRAINT emp_salary_min CHECK (salary > 0)
   , CONSTRAINT emp_email_uk UNIQUE (email)
);

--- Добавление значений в таблицу Департамент
INSERT INTO departments(department_name, manager_id, location_id) VALUES ('IT', 0, 0);
INSERT INTO departments(department_name, manager_id, location_id) VALUES ('Sales', 0, 0);
--jdbc:h2:file:/home/workspace/projects/wsmeter-manul/src/test/resources/data/employees
--- Добавление значений в таблицу Работник
INSERT INTO employees VALUES(0, 'Ирина Николаевна', 'Василькова', 'vasilkova@test', '+3(423)332-31-12', current_timestamp, 0, 1, 0.23, 0, 290);
INSERT INTO employees VALUES(1, 'Кирилл Петрович', 'Шниперсон', 'snippersonchik_a@test', '+3(423)332-31-12', current_timestamp, 0, 1, 0.23, 0, 280);
INSERT INTO employees VALUES(2, 'Валентина', 'Касикова', 'kasilkiva@test', '+3(423)332-31-13', current_timestamp, 0, 1, 0.23, 0, 280);
INSERT INTO employees VALUES(3, 'Оксана', 'Продавшкина','prodovashkina@test', '+3(423)332-33-33', current_timestamp, 0, 1, 0.23, 0, 290);
INSERT INTO employees VALUES(4, 'Максим', 'Шубин', 'shubin@test', '+3(423)332-44-44', current_timestamp, 0, 1, 0.23, 0, 280);

--SELECT * FROM employees;
--SELECT * FROM departments;