package org.wadzapi.employeeService.persist.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Абстрактный класс DAO для работы с сущностями предметной области через Hibernate
 */
@Repository
public abstract class AbstractHibernateDao<T> implements Dao<T> {

    /**
     * Класс, используемый в сохраняемой сущности
     */
    private final Class<T> persistedClazz;

    protected EntityManager entityManager;

    /**
     * Менеджерр для работы с сущностями
     */
    @PersistenceContext(name = "PersistenceUnit")
    public void setEntityManagerFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Конструктор класса
     *
     * @param persistedClazz класс, используемый в сохраняемой сущности
     */
    protected AbstractHibernateDao(Class<T> persistedClazz) {
        this.persistedClazz = persistedClazz;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void persist(T persistObject) {
        entityManager.persist(persistObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findOne(Object id) {
        return entityManager.find( persistedClazz, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery( "from " + persistedClazz.getName()).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T entity) {
        entityManager.merge( entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T entity) {
        entityManager.remove( entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete( entity );
    }
}
