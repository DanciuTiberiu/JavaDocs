package ro.teamnet.zerotohero.reflection;

import com.sun.org.apache.bcel.internal.generic.MULTIANEWARRAY;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {
    public static void main(String[] args) {
        //TODO get the class for a String object, and print it
		String a = "My String";
        System.out.println(a.getClass());

        //TODO get the class of an Enum, and print it
        System.out.println(MyEnum.A.getClass());


        //TODO get the class of a collection, and print it
        ArrayList<Integer> m = new ArrayList<>();
        m.add(1);
        m.add(2);
        m.add(3);
        System.out.println(m.getClass());
        

        //TODO get the class of a primitive type, and print it
        System.out.println(int.class);
        

        //TODO get and print the class for a field of primitive type
        PrivateObject privateObj = new PrivateObject();
        try {
            System.out.println(privateObj.getClass().getDeclaredField("a").getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        //TODO get and print the class for a primitive type, using the wrapper class

        Integer integr = new Integer(24);
        System.out.println(integr.TYPE);
        

        //TODO get the class for a specified class name

        System.out.println(privateObj.getClass());

        

        //TODO get the superclass of a class, and print it

        System.out.println(m.getClass().getSuperclass());
        //TODO get the superclass of the superclass above, and print it
        MyClass cls = new MyClass();
        System.out.println(cls.getClass().getSuperclass().getSuperclass());
        

        //TODO get and print the declared classes within some other class
        System.out.println(cls.getClass().getDeclaredClasses());
        

        //TODO print the number of constructors of a class
        ArrayList constr = new ArrayList();

        System.out.println(constr.getClass().getDeclaredConstructors().length);
        

        //TODO get and invoke a public constructor of a class

        try {
            cls.getClass().newInstance();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        

        //TODO get and print the class of one private field

        try {
            System.out.println(privateObj.getClass().getDeclaredField("b").getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


		//TODO set and print the value of one private field for an object

        try {
            Field f1 = privateObj.getClass().getDeclaredField("obj");
            f1.setAccessible(true);
            f1.set(privateObj, 50);
            System.out.println(f1.get(privateObj));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        //TODO get and print only the public fields class


        Field[] f2 = privateObj.getClass().getFields();
        for (int i = 0; i<f2.length; i++){
            System.out.println(f2[i].getType());
        };


        //TODO get and invoke one public method of a class

        try {
            Method adun = cls.getClass().getDeclaredMethod("adunare", int.class, int.class);
            System.out.println(adun.invoke(cls,100,52 ));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //TODO get and invoke one inherited method of a class
        PrivateObject prvt = new PrivateObject();

        try {
            Method adun = prvt.getClass().getSuperclass().getDeclaredMethod("adunare", int.class, int.class);
            System.out.println(adun.invoke(cls,100,52 ));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



        //TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())

        for(int i = 0; i <=1000; i++){
            cls.adunare(20,33);
        }
        System.out.println(System.currentTimeMillis());


		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?

        for (int i = 0; i <= 1000; i++){
            Method adun = null;
            try {
                adun = cls.getClass().getDeclaredMethod("adunare", int.class, int.class);
               adun.invoke(cls,100,52 );
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        System.out.println(System.currentTimeMillis());

    }
}
