package org.wadzapi.employeeService.persist.dao;

import org.springframework.stereotype.Repository;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;

/**
 * Created by vadik on 02.01.16.
 */
@Repository
public class DepartmentJpaDao extends AbstractHibernateDao<DepartmentOrm> {

    public DepartmentJpaDao() {
        super(DepartmentOrm.class);
    }
}
