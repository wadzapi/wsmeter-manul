package org.wadzapi.persister;

import org.wadzapi.persister.orm.DepartmentOrm;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public class DepartmentJpaPersiter implements Persister<DepartmentOrm> {

    @Override
    public List<DepartmentOrm> load() {
        Query query = createQuery("FROM departments");
        List<DepartmentOrm> departments = query.getResultList();
        return departments;
    }
}
