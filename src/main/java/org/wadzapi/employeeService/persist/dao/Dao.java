package org.wadzapi.employeeService.persist.dao;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public interface Dao<T> {

    Query createQuery(String query);

    void persist(T persistObject);

    T findOne( long id );

    List<T> findAll();

    void update(T entity);

    void delete(T entity );

    void deleteById(long entityId);
}
