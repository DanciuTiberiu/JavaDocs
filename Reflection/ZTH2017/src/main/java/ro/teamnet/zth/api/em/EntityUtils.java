package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiberiu.Danciu on 7/12/2017.
 */
public class EntityUtils {
    private EntityUtils(){
        throw new UnsupportedOperationException();
    }
    public static String getTableName(Class entity) throws NoSuchMethodException {
        Annotation[] annotation = entity.getAnnotations();
        for (int i = 0; i< entity.getAnnotations().length; i++){
            if (annotation[i].equals("Table")){
                try {
                    return (String)annotation[i].getClass().getMethod("name").invoke(entity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
        ArrayList array = new ArrayList();
        Field[] f1 = entity.getDeclaredFields();
        ColumnInfo obj = new ColumnInfo();
        for (int i = 0; i<f1.length; i++){
            if (f1[i].equals("Column") || f1[i].equals("Id")){
                obj.setColumnName(f1[i].getName());
                obj.setColumnType(f1[i].getType());
                try {
                    obj.setDbColumnName((String)f1.getClass().getMethod("name").invoke(entity));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                if (f1[i].equals("Id"))
                    obj.setId(true);
                else
                    obj.setId(false);
                array.add(obj);
            }
        }

        return array;
    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if (value instanceof BigDecimal && wantedType.getSimpleName().equals("Integer"))
            return (Integer) value;
        if (value instanceof BigDecimal && wantedType.getSimpleName().equals("Long"))
            return (Long) value;
        if (value instanceof BigDecimal && wantedType.getSimpleName().equals("Float"))
            return (Float) value;
        if (value instanceof BigDecimal && wantedType.getSimpleName().equals("Double"))
            return (Double) value;

        return value;
    }

    public static ArrayList getFieldsByAnnotations(Class clazz, Class annotation){
        Field[] fields = clazz.getFields();
        ArrayList list = new ArrayList();
        for (int i = 0; i<fields.length; i++){
            Annotation[] annotations = fields[i].getAnnotations();
            for (int j = 0; j<annotations.length; i++){
                if(annotations[i].getClass().getName().equals(annotation)){
                    list.add(annotations[i]);
                }
            }
        }
        return list;
    }

//    public static Object getSqlValue(Object object){
//        Annotation[] annotation = object.getClass().getAnnotations();
//        for (int i = 0; i<annotation.length; i++){
//            if (annotation[i].getClass().getAnnotations()) {
//                object.getClass()
//            }
//        }
//    }  NOT FINISHED !!!
}
