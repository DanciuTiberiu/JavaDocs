package ro.teamnet.zerotohero.reflection;

import java.util.ArrayList;

/**
 * Created by Tiberiu.Danciu on 7/12/2017.
 */
public class MyClass extends ArrayList {
    int a;
    int b;

    public MyClass(){};

    public MyClass(int a, int b){
        a = 2;
        b = 3;
    }

    public int adunare(int a, int b){
        return a + b;
    }

    public class AnotherClass{

    }
}
