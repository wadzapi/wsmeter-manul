package org.wadzapi.persister;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public interface Persister<T> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");

    EntityManager entityManager = emf.createEntityManager();

    default Query createQuery(String query) {
        return entityManager.createQuery(query);
    }

    @Transactional
    default void persist(T persistObject) {
        entityManager.persist(persistObject);
    }

    List<T> load();
}
