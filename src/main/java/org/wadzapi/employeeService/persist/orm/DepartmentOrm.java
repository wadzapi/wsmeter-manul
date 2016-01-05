package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;

/**
 * Сущность "Департамент"
 */
@Entity
@Table(name ="DEPARTMENTS")
public class DepartmentOrm {

    /**
     * Id сущности департамент
     */
    @Id
    @GeneratedValue
    @Column(name = "department_id", unique = true, nullable = false)
    private long id;

    /**
     * Название департамента
     */
    @Column(name = "department_name")
    private String name;

    /**
     * @return идентификатор сущности
     */
    public long getId() {
        return id;
    }

    /**
     * @param id идентификатор сущности
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return название департамента
     */
    public String getName() {
        return name;
    }

    /**
     * @param name название департамента
     */
    public void setName(String name) {
        this.name = name;
    }
}
