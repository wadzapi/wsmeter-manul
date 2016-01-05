package org.wadzapi.employeeService.persist.dao;

import org.springframework.stereotype.Repository;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

/**
 * Dao для работы с сущностью "Работник"
 */
@Repository
public class EmployeeJpaDao extends AbstractHibernateDao<EmployeeOrm> {

    /**
     * Конструктор класса
     */
    public EmployeeJpaDao() {
        super(EmployeeOrm.class);
    }
}