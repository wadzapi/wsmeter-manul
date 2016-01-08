package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;

/*
    TODO Подумать над сокращение бойлерплейтного кода
     - использовать рефлексию?
     - возможно ли поля сущности сделать final с Access(AccessType.FIELD)?
     - необходим ли для JPA констуктор без аргументов?
 */
/**
 * Сущность "Департамент"
 */
@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentOrm {

    /**
     * Id сущности департамент
     */
    @Id
    @GeneratedValue
    @Access(AccessType.FIELD)
    @Column(name = "department_id", unique = true, nullable = false)
    private long id;

    /**
     * Название департамента
     */
    @Access(AccessType.FIELD)
    @Column(name = "department_name")
    private String name;

    /**
     * Конструктор класса
     */
    public DepartmentOrm() {
    }

    /**
     * Конструктор класса
     *
     * @param departmentOrmBuilder билдер сущности Департамент
     */
    private DepartmentOrm(DepartmentOrmBuilder departmentOrmBuilder) {
        this.id = departmentOrmBuilder.id;
        this.name = departmentOrmBuilder.name;
    }

    /**
     * @return идентификатор сущности
     */
    public long getId() {
        return id;
    }

    /**
     * @return название департамента
     */
    public String getName() {
        return name;
    }

    /**
     * Класс-билдер сущности Департамент
     */
    public static final class DepartmentOrmBuilder {
        /**
         * Id сущности департамент
         */
        private long id;
        /**
         * Название департамента
         */
        private String name;

        /**
         * @param id идентификатор сущности
         * @return билдер сущности Департамент
         */
        public DepartmentOrmBuilder setId(long id) {
            this.id = id;
            return this;
        }

        /**
         * @param name название департамента
         * @return билдер сущности Департамент
         */
        public DepartmentOrmBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Метод построения сущности Департамент
         *
         * @return сущность департамент
         */
        public DepartmentOrm build() {
            return new DepartmentOrm(this);
        }
    }
}
