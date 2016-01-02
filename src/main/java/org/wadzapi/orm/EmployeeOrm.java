package org.wadzapi.orm;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
@Entity
public class EmployeeOrm {

    @Id
    @Column(name = "employee_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phone;

    @Column(name="hire_date")
    private Date hireDate;

    @Column(name = "job_id")
    private long jobId;

    @Column(name="salary")
    private BigInteger salary;

    @Column(name = "commision_pct")
    private Double commisionPct;

    @Column(name = "manager_id")
    private long managerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public Double getCommisionPct() {
        return commisionPct;
    }

    public void setCommisionPct(Double commisionPct) {
        this.commisionPct = commisionPct;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @ManyToOne(targetEntity = DepartmentOrm.class)
    @JoinColumn(name="employee_id", referencedColumnName="department_id")
    private List<DepartmentOrm> departmentOrmList;


    public List<DepartmentOrm> getDepartmentOrmList() {
        return departmentOrmList;
    }

    public void setDepartmentOrmList(List<DepartmentOrm> departmentOrmList) {
        this.departmentOrmList = departmentOrmList;
    }
}
