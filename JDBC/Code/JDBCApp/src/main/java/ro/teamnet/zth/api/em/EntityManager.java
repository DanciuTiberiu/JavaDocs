package ro.teamnet.zth.api.em;

import java.util.List;

/**
 * Created by Tiberiu.Danciu on 7/13/2017.
 */
public interface EntityManager {
    <T> T findById(Class<T> entityClass, Long id);
    <T> T getNextIdVal(String tableName, String columnIdName);
    <T> Object Insert(T entity);
    <T>List<T> findAll(Class<T> entityClass);
}
