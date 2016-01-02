package org.wadzapi.persister;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vadik on 02.01.16.
 */
public interface Persister<T> {

    Query createQuery(String query);

    void persist(T persistObject);

    List<T> load();
}
