package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tiberiu.Danciu on 7/13/2017.
 */
public class EntityManagerImpl {
    <T> T findById(Class<T> entityClass, Long id) {
        Connection con = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> column = EntityUtils.getColumns(entityClass);
        List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);

        Condition cond = new Condition();
        for (ColumnInfo colum : column) {
            if (colum.isId()) {
                cond.setColumnName(colum.getDbColumnName());
                cond.setValue(id);
            }
        }

        QueryBuilder build = new QueryBuilder();
        build.setQueryType(QueryType.SELECT);
        build.addQueryColumns(column);
        build.setTableName(getName);
        build.addCondition(cond);
        String sql = build.createQuery();
        try {
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            if (resultSet.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo col : column) {
                    Field field = instance.getClass().getDeclaredField(col.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, EntityUtils.castFromSqlType(resultSet.getObject(col.getDbColumnName()), field.getType()));
                }
                return instance;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    Long getNextIdVal(String tableName, String columnIdName){
        Connection connect = DBManager.getConnection();
        Long value = 0L;
        try {
            Statement statement = connect.createStatement();
            String querry = "SELECT MAX" + (columnIdName) + "FROM" + tableName;
            ResultSet re = statement.executeQuery(querry);
            value = re.getLong("Max(" +columnIdName + ")")+1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    <T> Object insert(T entity){
        Connection con = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> column = EntityUtils.getColumns(entity.getClass());

        Long id = 0L;

        for (ColumnInfo col: column) {
            if (col.isId()){
                id = (Long)col.getValue();
                try {
                    Field field = entity.getClass().getDeclaredField(col.getColumnName());
                    col.setValue(getNextIdVal(getName, field.getName()));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                  Field f = entity.getClass().getDeclaredField(col.getColumnName());
                  f.setAccessible(true);
                  col.setValue(f);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }

        QueryBuilder build = new QueryBuilder();
        build.setTableName(getName);
        build.addQueryColumns(column);
        build.setQueryType(QueryType.INSERT);

        String a = build.createQuery();
        Statement state = null;
        try {
            state = con.createStatement();
            ResultSet rez = state.executeQuery(a);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findById(entity.getClass(), id);
    }

    <T>List<T> findAll(Class<T> entityClass){
        Connection connect = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entityClass.getClass());
        List<ColumnInfo> column = EntityUtils.getColumns(entityClass.getClass());

        QueryBuilder build = new QueryBuilder();
        build.setTableName(getName);
        build.setQueryType(QueryType.SELECT);
        build.addQueryColumns(column);
        String qerBuild = build.createQuery();
        ArrayList<T> list = new ArrayList<>();

        try {
            Statement state = connect.createStatement();
            ResultSet rezult = state.executeQuery(qerBuild);
            while (rezult.next()){
                T instance = entityClass.newInstance();
                for (ColumnInfo col: column) {
                    Field field = instance.getClass().getDeclaredField(col.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, rezult.getObject(col.getDbColumnName()));
                    list.add(instance);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return list;


    }
}
