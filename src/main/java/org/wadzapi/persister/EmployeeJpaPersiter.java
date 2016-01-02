package org.wadzapi.persister;

import org.wadzapi.persister.orm.EmployeeOrm;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public class EmployeeJpaPersiter implements Persister<EmployeeOrm> {

    @Override
    public List<EmployeeOrm> load() {
        Query query = createQuery("FROM employees");
        List<EmployeeOrm> departments = query.getResultList();
        return departments;
    }
}