#Изучение и бенчмаркинг производительности WS-CSF на jProfiler
- - -

## Видение
Основная направленность проекта --- исследование потенциала и работа с веб-сервисами и интеграционным набором инструментов.
Для исследования производительности и бенчмаркинга клиент-серверного взаимодействия возможно применение jMeter.

## Задача
На первоначальном этапе необходимо реализовать rest веб-сервис с минимальным ui-обвесом и исследовать инструменты интеграции и производительности.

### Технологии
- Spring IoC
- Apache CXF
- JPA (Hibernate Entity Manager)
- Struts 2
- DB: PostgreSql 9,4/ H2

### Список TODO:
 - Настроить JPA-конфиги на использование файловой БД (h2) в тестах
 - Поправить типы данных в БД на varchar, исправить тесты

### Заметки:
1. За основу БД принят порт набора данных "Работники" из проекта [postgres9postgres8employees](https://bitbucket.org/wrightsolutions/postgres9postgres8employees) и [форкнут](https://bitbucket.org/wadzapi/postgres9postgres8employees)
2. [Для запроса к локальному веб-сервису](http://localhost:8080/restService01-1.0-SNAPSHOT/rest/employeeservices/getemployeedetail?employeeId=1)
3. Пароли к локальным и файловым БД:
        sa;'' - h2
        restadmin01:'123456' - wrightemployees (psql 9.4)
4. В тестовой БД использован экспорт из Postgresql в H2 продуктовой через SQLWorkbench DataPump tool с ограниченией на departments с 
    dep_no=('d003', 'd004')
и employees с emp_no=(10120, 10123, 10124, 10130, 10133, 10134)
 5.