CREATE TABLE employees
   ( employee_id NUMBER(6)
   , first_name VARCHAR2(20)
   , last_name VARCHAR2(25)
   CONSTRAINT emp_last_name_nn NOT NULL
   , email VARCHAR2(25)
   CONSTRAINT emp_email_nn NOT NULL
   , phone_number VARCHAR2(20)
   , hire_date DATE
   CONSTRAINT emp_hire_date_nn NOT NULL
   , job_id VARCHAR2(10)
   CONSTRAINT emp_job_nn NOT NULL
   , salary NUMBER(8,2)
   , commission_pct NUMBER(2,2)
   , manager_id NUMBER(6)
   , department_id NUMBER(4)
   , CONSTRAINT emp_salary_min
   CHECK (salary > 0) 
   , CONSTRAINT emp_email_uk
   UNIQUE (email)
);

CREATE UNIQUE INDEX emp_emp_id_pk ON employees (employee_id);

ALTER TABLE employees ALTER COLUMN employee_id SET NOT NULL;
ALTER TABLE employees ADD PRIMARY KEY (employee_id);
ALTER TABLE departments ALTER COLUMN department_id SET NOT NULL;

CREATE TABLE departments
  (department_id NUMBER(4)
  , department_name VARCHAR2(30)
  CONSTRAINT dept_name_nn NOT NULL
  , manager_id NUMBER(6)
  , location_id NUMBER(4)
);

CREATE UNIQUE INDEX dept_id_pk ON departments (department_id) ;
ALTER TABLE departments ADD PRIMARY KEY (department_id);

CREATE SEQUENCE departments_seq
  START WITH 280
  INCREMENT BY 10
  MAXVALUE 9990
  NOCACHE
  NOCYCLE;

ALTER TABLE departments ADD PRIMARY KEY(department_id)
ALTER TABLE employees ADD FOREIGN KEY(department_id) REFERENCES departments