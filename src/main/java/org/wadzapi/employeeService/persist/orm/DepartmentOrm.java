package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность "Департамент"
 */
@Entity
@Table(name = "departments")
@AttributeOverride(name = "id", column = @Column(name = "dept_no", unique = true, nullable = false))
public class DepartmentOrm extends AbstactOrm {

    /**
     * Название департамента
     */
    @Access(AccessType.FIELD)
    @Column(name = "dept_name")
    private String name;

    /**
     * Список работников департамента
     */
    //TODO Допилить маппинги manyToMany и добавить в тесты
    @Transient
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "departmentList")
    private List<EmployeeOrm> employeeList;

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
        super(departmentOrmBuilder.id);
        this.name = departmentOrmBuilder.name;
        this.employeeList = departmentOrmBuilder.employeeList;
    }

    /**
     * @return название департамента
     */
    public String getName() {
        return name;
    }

    /**
     * @return список работников департамента
     */
    public List<EmployeeOrm> getEmployeeList() {
        return employeeList;
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
         * Список работников департамента
         */
        private List<EmployeeOrm> employeeList;

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
         * @param employeeList список работников департамента
         */
        public void setEmployeeList(List<EmployeeOrm> employeeList) {
            this.employeeList = employeeList;
        }

        /**
         * Метод построения сущности Департамент
         * @return сущность департамент
         */
        public DepartmentOrm build() {
            return new DepartmentOrm(this);
        }
    }
}
