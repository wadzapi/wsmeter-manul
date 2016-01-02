package org.wadzapi.persister;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public abstract class AbstractPersister<T> implements Persister<T> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_service01");

    EntityManager entityManager = emf.createEntityManager();

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

    @Override
    public abstract List<T> load();
}
