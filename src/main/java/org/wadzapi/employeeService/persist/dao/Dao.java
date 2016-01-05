package org.wadzapi.employeeService.persist.dao;

import javax.persistence.Query;
import java.util.List;

/**
 * Интерфейс для работы с состоянием сущнотей в БД
 */
public interface Dao<T> {

    /**
     * Метод создания именованного запроса
     *
     * @param query название запроса
     * @return запрос
     */
    Query createQuery(String query);

    /**
     * Метод сохранения состояния сущности
     * @param persistObject сущность для сохранения
     */
    void persist(T persistObject);

    /**
     * Метод поиска сущности по идентификатору
     *
     * @param id идентификатор сущности
     * @return сущность с указанным идентификтором
     */
    T findOne(long id);

    /**
     * Метод поиска полного списка сущностей
     * @return полный список сущностей
     */
    List<T> findAll();

    /**
     * Метод обновления состояния сущности
     * @param entity сущность
     */
    void update(T entity);

    /**
     * Метод удаления состояния сущности из контекста
     * @param entity сущность
     */
    void delete(T entity);

    /**
     * Метод удаления состояния сущности по идентификатору
     * @param entityId идентификатор сущности
     */
    void deleteById(long entityId);
}
