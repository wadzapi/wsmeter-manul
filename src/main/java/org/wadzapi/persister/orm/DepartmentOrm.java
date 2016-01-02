package org.wadzapi.persister.orm;

import javax.persistence.*;

/**
 * Сущнсоть департамент
 */
@Entity
@Table(name ="departments")
public class DepartmentOrm {

    @Id
    @Column(name = "department_id")
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
