package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Сущность "Работник"
 */
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeOrm {

    /**
     * Идентификатор сущности
     */
    @Id
    @Column(name = "EMPLOYEE_ID")
    private long id;

    /**
     * Имя работника
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * Фамилия работника
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * Email
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * Номер телефона
     */
    @Column(name = "PHONE_NUMBER")
    private String phone;

    /**
     * Дата наема
     */
    @Column(name="HIRE_DATE")
    private Date hireDate;

    /**
     * Идентификатор профессии
     */
    @Column(name = "JOB_ID")
    private long jobId;

    /**
     * Зарплата
     */
    @Column(name="SALARY")
    private BigInteger salary;

    /**
     * Налог
     */
    @Column(name = "COMMISSION_PCT")
    private Double commisionPct;

    /**
     * Идентификатор менеджера
     */
    @Column(name = "MANAGER_ID")
    private long managerId;

    /**
     * Департамент
     */
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private DepartmentOrm department;

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
     * @return имя работника
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName имя работника
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return фамилия работника
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName фамилия работника
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return номер телефона
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone номер телефона
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return дата наема
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate дата наема
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * @return идентификатор профессии
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * @param jobId идентификатор профессии
     */
    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    /**
     * @return зарплата
     */
    public BigInteger getSalary() {
        return salary;
    }

    /**
     * @param salary зарплата
     */
    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    /**
     * @return налог
     */
    public Double getCommisionPct() {
        return commisionPct;
    }

    /**
     * @param commisionPct налог
     */
    public void setCommisionPct(Double commisionPct) {
        this.commisionPct = commisionPct;
    }

    /**
     * @return идентификатор менеджера
     */
    public long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId идентификатор менеджера
     */
    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    /**
     * @return департамент
     */
    public DepartmentOrm getDepartment() {
        return department;
    }

    /**
     * @param department департамент
     */
    public void setDepartment(DepartmentOrm department) {
        this.department = department;
    }
}
