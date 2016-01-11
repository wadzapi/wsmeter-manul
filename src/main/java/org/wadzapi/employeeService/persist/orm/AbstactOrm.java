package org.wadzapi.employeeService.persist.orm;

import javax.persistence.*;

/**
 *
 */
@MappedSuperclass
public class AbstactOrm {

    /**
     * Идентификатор сущности
     */
    @Id
    @Access(AccessType.FIELD)
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    /**
     * Конструктор класса
     */
    public AbstactOrm() {
    }

    /**
     * Конструктор класса
     *
     * @param id идентификатор сущности
     */
    public AbstactOrm(long id) {
        this.id = id;
    }

    /**
     * @return идентификатор сущности
     */
    public long getId() {
        return id;
    }

    /**
     * @param id идентификтор сущности
     */
    public void setId(long id) {
        this.id = id;
    }
}
