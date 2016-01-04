package org.wadzapi.employeeService.persist.dao;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public abstract class AbstractHibernateDao<T> implements Dao<T> {

    private static final String PERSIST_UNIT_NAME = "PersistenceUnit";

    private final Class<T> persistedClazz;

    @PersistenceContext
    EntityManager entityManager;

    protected AbstractHibernateDao(Class<T> persistedClazz) {
        this.persistedClazz = persistedClazz;
        this.entityManager = createEntityManager();

    }

    @Override
    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }

    //TODO Разобраться с транзакционностью
    //@Transactional
    @Override
    public void persist(T persistObject) {
        entityManager.persist(persistObject);
    }

    private static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSIST_UNIT_NAME);
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    @Override
    public T findOne(long id) {
        return entityManager.find( persistedClazz, id );
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery( "from " + persistedClazz.getName()).getResultList();
    }

    @Override
    public void update(T entity) {
        entityManager.merge( entity );
    }

    @Override
    public void delete(T entity) {
        entityManager.remove( entity );
    }

    @Override
    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete( entity );
    }
}
