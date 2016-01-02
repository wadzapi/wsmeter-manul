--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: departments; Type: TABLE; Schema: public; Owner: restadmin01; Tablespace: 
--

CREATE TABLE departments (
    department_id bigint NOT NULL,
    department_name character(30) NOT NULL,
    manager_id numeric(6,0),
    location_id numeric(4,0)
);


ALTER TABLE departments OWNER TO restadmin01;

--
-- Name: departments_department_id_seq; Type: SEQUENCE; Schema: public; Owner: restadmin01
--

CREATE SEQUENCE departments_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE departments_department_id_seq OWNER TO restadmin01;

--
-- Name: departments_department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: restadmin01
--

ALTER SEQUENCE departments_department_id_seq OWNED BY departments.department_id;


--
-- Name: departments_seq; Type: SEQUENCE; Schema: public; Owner: restadmin01
--

CREATE SEQUENCE departments_seq
    START WITH 280
    INCREMENT BY 10
    NO MINVALUE
    MAXVALUE 9990
    CACHE 1;


ALTER TABLE departments_seq OWNER TO restadmin01;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: restadmin01; Tablespace: 
--

CREATE TABLE employees (
    employee_id integer NOT NULL,
    first_name character(20) NOT NULL,
    last_name character varying(25) NOT NULL,
    email character varying(25) NOT NULL,
    phone_number character varying(20),
    hire_date date NOT NULL,
    job_id character varying(10) NOT NULL,
    salary numeric(8,2),
    commission_pct numeric(2,2),
    manager_id numeric(6,0),
    department_id integer,
    CONSTRAINT emp_salary_min CHECK ((salary > (0)::numeric))
);


ALTER TABLE employees OWNER TO restadmin01;

--
-- Name: department_id; Type: DEFAULT; Schema: public; Owner: restadmin01
--

ALTER TABLE ONLY departments ALTER COLUMN department_id SET DEFAULT nextval('departments_department_id_seq'::regclass);


--
-- Data for Name: departments; Type: TABLE DATA; Schema: public; Owner: restadmin01
--

COPY departments (department_id, department_name, manager_id, location_id) FROM stdin;
481	Sales                         	1	1
300	IT                            	0	0
\.


--
-- Name: departments_department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: restadmin01
--

SELECT pg_catalog.setval('departments_department_id_seq', 1, false);


--
-- Name: departments_seq; Type: SEQUENCE SET; Schema: public; Owner: restadmin01
--

SELECT pg_catalog.setval('departments_seq', 480, true);


--
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: restadmin01
--

COPY employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) FROM stdin;
0	Ирина Николаевна    	Василькова	vasilkova@test	+3(423)332-31-12	2016-01-02	0	1.00	0.23	0	300
1	Кирилл Петрович     	Шниперсон	snippersonchik_a@test	+3(423)332-31-12	2016-01-02	0	1.00	0.23	0	300
2	Валентина           	Касикова	kasilkiva@test	+3(423)332-31-13	2016-01-02	0	1.00	0.23	0	300
3	Оксана              	Продавшкина	prodovashkina@test	+3(423)332-33-33	2016-01-02	0	1.00	0.23	0	481
4	Максим              	Шубин	shubin@test	+3(423)332-44-44	2016-01-02	0	1.00	0.23	0	481
\.


--
-- Name: departments_location_id_key; Type: CONSTRAINT; Schema: public; Owner: restadmin01; Tablespace: 
--

ALTER TABLE ONLY departments
    ADD CONSTRAINT departments_location_id_key UNIQUE (location_id);


--
-- Name: departments_manager_id_key; Type: CONSTRAINT; Schema: public; Owner: restadmin01; Tablespace: 
--

ALTER TABLE ONLY departments
    ADD CONSTRAINT departments_manager_id_key UNIQUE (manager_id);


--
-- Name: departments_pkey; Type: CONSTRAINT; Schema: public; Owner: restadmin01; Tablespace: 
--

ALTER TABLE ONLY departments
    ADD CONSTRAINT departments_pkey PRIMARY KEY (department_id);


--
-- Name: emp_email_uk; Type: CONSTRAINT; Schema: public; Owner: restadmin01; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT emp_email_uk UNIQUE (email);


--
-- Name: employees_pkey; Type: CONSTRAINT; Schema: public; Owner: restadmin01; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (employee_id);


--
-- Name: dept_id_pk; Type: INDEX; Schema: public; Owner: restadmin01; Tablespace: 
--

CREATE UNIQUE INDEX dept_id_pk ON departments USING btree (department_id);


--
-- Name: employees_department_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: restadmin01
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_department_id_fkey FOREIGN KEY (department_id) REFERENCES departments(department_id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

