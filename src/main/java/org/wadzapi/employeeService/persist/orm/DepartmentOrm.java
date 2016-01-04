package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;

/**
 * Сущнсоть департамент
 */
@Entity
@Table(name ="DEPARTMENTS")
public class DepartmentOrm {

    @Id
    @GeneratedValue
    @Column(name = "department_id", unique = true, nullable = false)
    private long id;

    @Column(name = "department_name")
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
