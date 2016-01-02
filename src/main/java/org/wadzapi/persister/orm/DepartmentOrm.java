package org.wadzapi.persister.orm;

import javax.persistence.*;



@Table(name ="departments")
public class DepartmentOrm {

    @Id
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name")
    private String name;

    @OneToMany(mappedBy = "employee")
    private DepartmentOrm departmentOrm;


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

    public DepartmentOrm getDepartmentOrm() {
        return departmentOrm;
    }

    public void setDepartmentOrm(DepartmentOrm departmentOrm) {
        this.departmentOrm = departmentOrm;
    }

}
