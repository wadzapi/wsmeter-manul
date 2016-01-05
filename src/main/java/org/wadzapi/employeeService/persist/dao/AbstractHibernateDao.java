package org.wadzapi.employeeService.persist.dao;

import javax.persistence.*;
import java.util.List;

/**
 * Абстрактный класс DAO для работы с сущностями предметной области через Hibernate
 */
public abstract class AbstractHibernateDao<T> implements Dao<T> {

    /**
     * Имя persistant-unit, используемое в проекте в продуктовом профиле
     */
    private static final String PERSIST_UNIT_NAME = "PersistenceUnit";

    /**
     * Класс, используемый в сохраняемой сущности
     */
    private final Class<T> persistedClazz;

    /**
     * Менеджерр для работы с сущностями
     */
    @PersistenceContext
    EntityManager entityManager;

    /**
     * Конструктор класса
     *
     * @param persistedClazz класс, используемый в сохраняемой сущности
     */
    protected AbstractHibernateDao(Class<T> persistedClazz) {
        this.persistedClazz = persistedClazz;
        this.entityManager = createEntityManager();

    }

    /**
     * Метод создания менеджера сущностей
     *
     * @return менеджер сущностей
     */
    private static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSIST_UNIT_NAME);
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
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
    //TODO Разобраться с транзакционностью
    //@Transactional
    @Override
    public void persist(T persistObject) {
        entityManager.persist(persistObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findOne(long id) {
        return entityManager.find( persistedClazz, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
