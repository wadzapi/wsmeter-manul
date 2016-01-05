package org.wadzapi.employeeService.persist.dao;

import org.springframework.stereotype.Repository;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;

/**
 * Dao для работы с сущностью работник
 */
@Repository
public class DepartmentJpaDao extends AbstractHibernateDao<DepartmentOrm> {

    /**
     * Конструктор класса
     */
    public DepartmentJpaDao() {
        super(DepartmentOrm.class);
    }
}
