package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/*
    TODO Подумать над сокращение бойлерплейтного кода
     - использовать рефлексию?
     - возможно ли поля сущности сделать final с Access(AccessType.FIELD)?
     - необходим ли для JPA констуктор без аргументов?
 */
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
    @Access(AccessType.FIELD)
    @Column(name = "EMPLOYEE_ID")
    private long id;

    /**
     * Имя работника
     */
    @Access(AccessType.FIELD)
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * Фамилия работника
     */
    @Access(AccessType.FIELD)
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * Email
     */
    @Access(AccessType.FIELD)
    @Column(name = "EMAIL")
    private String email;

    /**
     * Номер телефона
     */
    @Access(AccessType.FIELD)
    @Column(name = "PHONE_NUMBER")
    private String phone;

    /**
     * Дата наема
     */
    @Access(AccessType.FIELD)
    @Column(name = "HIRE_DATE")
    private Date hireDate;

    /**
     * Идентификатор профессии
     */
    @Access(AccessType.FIELD)
    @Column(name = "JOB_ID")
    private long jobId;

    /**
     * Зарплата
     */
    @Access(AccessType.FIELD)
    @Column(name = "SALARY")
    private BigInteger salary;

    /**
     * Налог
     */
    @Access(AccessType.FIELD)
    @Column(name = "COMMISSION_PCT")
    private Double commisionPct;

    /**
     * Идентификатор менеджера
     */
    @Access(AccessType.FIELD)
    @Column(name = "MANAGER_ID")
    private long managerId;

    /**
     * Департамент
     */
    @ManyToOne
    @Access(AccessType.FIELD)
    @JoinColumn(name = "DEPARTMENT_ID")
    private DepartmentOrm department;

    /**
     * Конструктор класса
     */
    public EmployeeOrm() {
    }

    /**
     * Конструктор класса
     * @param employeeOrmBuilder билдер сущности Работник
     */
    private EmployeeOrm(EmployeeOrmBuilder employeeOrmBuilder) {
        this.id = employeeOrmBuilder.id;
        this.firstName = employeeOrmBuilder.firstName;
        this.lastName = employeeOrmBuilder.lastName;
        this.email = employeeOrmBuilder.email;
        this.phone = employeeOrmBuilder.phone;
        this.hireDate = employeeOrmBuilder.hireDate;
        this.jobId = employeeOrmBuilder.jobId;
        this.salary = employeeOrmBuilder.salary;
        this.commisionPct = employeeOrmBuilder.commisionPct;
        this.managerId = employeeOrmBuilder.managerId;
        this.department = employeeOrmBuilder.department;
    }

    /**
     * @return идентификатор сущности
     */
    public long getId() {
        return id;
    }

    /**
     * @return имя работника
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return фамилия работника
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return номер телефона
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return дата наема
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @return идентификатор профессии
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * @return зарплата
     */
    public BigInteger getSalary() {
        return salary;
    }

    /**
     * @return налог
     */
    public Double getCommisionPct() {
        return commisionPct;
    }

    /**
     * @return идентификатор менеджера
     */
    public long getManagerId() {
        return managerId;
    }

    /**
     * @return департамент
     */
    public DepartmentOrm getDepartment() {
        return department;
    }

    /**
     * Класс-билдер сущности "Работник"
     */
    public static final class EmployeeOrmBuilder {
        /**
         * Идентификатор сущности
         */
        private long id;
        /**
         * Имя работника
         */
        private String firstName;
        /**
         * Фамилия работника
         */
        private String lastName;
        /**
         * Email
         */
        private String email;
        /**
         * Номер телефона
         */
        private String phone;
        /**
         * Дата наема
         */
        private Date hireDate;
        /**
         * Идентификатор профессии
         */
        private long jobId;
        /**
         * Зарплата
         */
        private BigInteger salary;
        /**
         * Налог
         */
        private Double commisionPct;
        /**
         * Идентификатор менеджера
         */
        private long managerId;
        /**
         * Департамент
         */
        private DepartmentOrm department;

        /**
         * @param id идентификатор сущности
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setId(long id) {
            this.id = id;
            return this;
        }

        /**
         * @param firstName имя работника
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * @param lastName фамилия работника
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * @param email email
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * @param phone номер телефона
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * @param hireDate дата наема
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setHireDate(Date hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        /**
         * @param jobId идентификатор профессии
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setJobId(long jobId) {
            this.jobId = jobId;
            return this;
        }

        /**
         * @param salary зарплата
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setSalary(BigInteger salary) {
            this.salary = salary;
            return this;
        }

        /**
         * @param commisionPct налог
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setCommisionPct(Double commisionPct) {
            this.commisionPct = commisionPct;
            return this;
        }

        /**
         * @param managerId идентификатор менеджера
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setManagerId(long managerId) {
            this.managerId = managerId;
            return this;
        }

        /**
         * @param department департамент
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setDepartment(DepartmentOrm department) {
            this.department = department;
            return this;
        }

        /**
         * Метод построения сущности Работник
         *
         * @return сущность работник
         */
        public EmployeeOrm build() {
            return new EmployeeOrm(this);
        }
    }
}
