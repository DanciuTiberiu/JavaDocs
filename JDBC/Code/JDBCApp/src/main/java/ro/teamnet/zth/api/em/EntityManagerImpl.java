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
import java.util.Map;


/**
 * Created by Tiberiu.Danciu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager{
    public <T> T findById(Class<T> entityClass, Long id) {
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

    public Long getNextIdVal(String tableName, String columnIdName){
        Connection connect = DBManager.getConnection();
        Long value = 0L;
        try {
            Statement statement = connect.createStatement();
            String querry = "SELECT MAX(" + columnIdName + ") FROM " + tableName;
            ResultSet re = statement.executeQuery(querry);
            re.next();
            value = re.getLong("Max(" +columnIdName + ")")+1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }






    public <T> Object insert(T entity){
        Connection con = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> column = EntityUtils.getColumns(entity.getClass());

        Long id = 0L;
        for (ColumnInfo col: column) {
            if (col.isId()){

                try {
                    Field field = entity.getClass().getDeclaredField(col.getColumnName());
                    col.setValue(getNextIdVal(getName, col.getDbColumnName()));
                    id = (Long)col.getValue();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                  Field f = entity.getClass().getDeclaredField(col.getColumnName());
                  f.setAccessible(true);
                  col.setValue(f.get(entity));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
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




    public  <T>List<T> findAll(Class<T> entityClass){
        Connection connect = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> column = EntityUtils.getColumns(entityClass);

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
                    field.set(instance, EntityUtils.castFromSqlType(rezult.getObject(col.getDbColumnName()), field.getType()));

                }
                list.add(instance);
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




    public <T> T update(T entity){
        Connection connect = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> column = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo col: column) {
            try {
                Field field = entity.getClass().getDeclaredField(col.getColumnName());
                field.setAccessible(true);
                col.setValue(field.get(entity));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

            Long id = 0L;

            Condition cond = new Condition();
            for (ColumnInfo columnInfo: column) {
                if (columnInfo.isId()){
                    cond.setColumnName(columnInfo.getDbColumnName());
                    cond.setValue(columnInfo.getValue());
                    id = (Long) columnInfo.getValue();

                }
            }

            QueryBuilder build = new QueryBuilder();
            build.setQueryType(QueryType.UPDATE);
            build.setTableName(getName);
            build.addQueryColumns(column);
            build.addCondition(cond);

            String qr = build.createQuery();
            Statement stmt = null;

        try {
            stmt = connect.createStatement();
            ResultSet rez = stmt.executeQuery(qr);
            rez.next();


            return (T) findById(entity.getClass(), id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }





    public void delete(Object entity){
        Connection connect = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> column = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo col: column) {
            try {
                Field field = entity.getClass().getDeclaredField(col.getColumnName());
                field.setAccessible(true);
                col.setValue(field.get(entity));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Condition cond = new Condition();
        for (ColumnInfo columnInfo: column) {
            if (columnInfo.isId()){
                cond.setColumnName(columnInfo.getDbColumnName());
                cond.setValue(columnInfo.getValue());
            }
        }

        QueryBuilder build = new QueryBuilder();
        build.setQueryType(QueryType.DELETE);
        build.setTableName(getName);
        build.addQueryColumns(column);
        build.addCondition(cond);

        String qr = build.createQuery();
        Statement stmt = null;


        try {
            stmt = connect.createStatement();
            ResultSet rez = stmt.executeQuery(qr);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params){
        Connection connect = DBManager.getConnection();
        String getName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> column = EntityUtils.getColumns(entityClass);

//        for (ColumnInfo col: column) {
//            try {
//                Field field = entityClass.getDeclaredField(col.getColumnName());
//                field.setAccessible(true);
//                col.setValue(field.get(entityClass.get));
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }

        QueryBuilder build = new QueryBuilder();

        for (Map.Entry<String, Object> entry: params.entrySet()) {
            Condition condition = new Condition();
            condition.setColumnName(entry.getKey());
            condition.setValue(entry.getValue());
            build.addCondition(condition);
        }


        build.setQueryType(QueryType.SELECT);
        build.setTableName(getName);
        build.addQueryColumns(column);

        String qr = build.createQuery();
        try {
            Statement stmt = connect.createStatement();
            ResultSet rez = stmt.executeQuery(qr);

            ArrayList<T> list = new ArrayList<>();

            while (rez.next()){
                T instance = entityClass.newInstance();
                for (ColumnInfo col: column) {
                    Field field = instance.getClass().getDeclaredField(col.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, EntityUtils.castFromSqlType(rez.getObject(col.getDbColumnName()), field.getType()));
                    list.add(instance);
                    return list;
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
        return null;
    }
}
