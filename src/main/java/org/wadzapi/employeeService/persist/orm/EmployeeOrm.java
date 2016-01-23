package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Сущность "Работник"
 */
@Entity
@Table(name = "employees")
@AttributeOverride(name = "id", column = @Column(name = "EMP_NO", unique = true, nullable = false))
public class EmployeeOrm extends AbstactOrm {

    /**
     * Дата рождения
     */
    @Access(AccessType.FIELD)
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * Имя работника
     */
    @Access(AccessType.FIELD)
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия работника
     */
    @Access(AccessType.FIELD)
    @Column(name = "last_name")
    private String lastName;

    /**
     * Пол
     */
    @Access(AccessType.FIELD)
    @Column(name = "gender")
    private String gender;

    /**
     * Дата наема
     */
    @Access(AccessType.FIELD)
    @Column(name = "hire_date")
    private Date hireDate;

    /**
     * Дата увольнения
     */
    @Access(AccessType.FIELD)
    @Column(name = "leave_date")
    private Date leaveDate;

    /**
     * Список департаментаментов работника
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dept_emp",
            joinColumns = {@JoinColumn(name = "dept_no", referencedColumnName = "emp_no")})
    @Access(AccessType.FIELD)
    //TODO Допилить маппинги manyToMany и добавить в тесты
    @Transient
    private List<DepartmentOrm> departmentList;

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
        super(employeeOrmBuilder.id);
        this.firstName = employeeOrmBuilder.firstName;
        this.lastName = employeeOrmBuilder.lastName;
        this.hireDate = employeeOrmBuilder.hireDate;
        this.leaveDate = employeeOrmBuilder.leaveDate;
        this.departmentList = employeeOrmBuilder.departmentList;
        this.birthDate = employeeOrmBuilder.birthDate;
        this.gender = employeeOrmBuilder.gender;
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
     * @return дата наема
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @return дата увольнения
     */
    public Date getLeaveDate() {
        return leaveDate;
    }

    /**
     * @return список департаментаментов работника
     */
    public List<DepartmentOrm> getDepartmentList() {
        return departmentList;
    }

    /**
     * @return дата рождения
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @return пол
     */
    public String getGender() {
        return gender;
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
         * Дата рождения
         */
        private Date birthDate;
        /**
         * Пол
         */
        private String gender;
        /**
         * Имя работника
         */
        private String firstName;
        /**
         * Фамилия работника
         */
        private String lastName;
        /**
         * Дата наема
         */
        private Date hireDate;
        /**
         * Дата увольнения
         */
        private Date leaveDate;
        /**
         * Список департаментаментов работника
         */
        private List<DepartmentOrm> departmentList;

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
         * @param hireDate дата наема
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setHireDate(Date hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        /**
         * @param leaveDate дата увольнения
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setLeaveDate(Date leaveDate) {
            this.leaveDate = leaveDate;
            return this;
        }

        /**
         * @param departmentList список департаментаментов работника
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setDepartmentList(List<DepartmentOrm> departmentList) {
            this.departmentList = departmentList;
            return this;
        }

        /**
         * @param birthDate дата рождения
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * @param gender пол
         * @return билдер сущности
         */
        public EmployeeOrmBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Метод построения сущности Работник
         * @return сущность работник
         */
        public EmployeeOrm build() {
            return new EmployeeOrm(this);
        }
    }
}
