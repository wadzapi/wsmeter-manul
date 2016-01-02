package org.wadzapi.persister;

import org.springframework.stereotype.Component;
import org.wadzapi.persister.orm.EmployeeOrm;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
@Component
public class EmployeeJpaPersiter extends AbstractPersister<EmployeeOrm> {

    @Override
    public List<EmployeeOrm> load() {
        Query query = createQuery("FROM employees");
        List<EmployeeOrm> departments = query.getResultList();
        return departments;
    }
}