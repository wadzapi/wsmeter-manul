package org.wadzapi.employeeService.persist.dao;

import org.springframework.stereotype.Repository;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

/**
 * Created by vadik on 02.01.16.
 */
@Repository
public class EmployeeJpaDao extends AbstractHibernateDao<EmployeeOrm> {

    public EmployeeJpaDao() {
        super(EmployeeOrm.class);
    }
}