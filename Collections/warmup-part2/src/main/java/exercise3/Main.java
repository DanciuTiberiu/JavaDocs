package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Tiberiu.Danciu on 7/7/2017.
 */
public class Main {
    public static void main(String[] args) {
        Map<EqualsAndHashcode, BigDecimal> studenti = new HashMap<EqualsAndHashcode, BigDecimal>();
        Map<EqualsAndHashCode2, BigDecimal> studenti2 = new HashMap<EqualsAndHashCode2, BigDecimal>();
        Map<EqualsAndHashCode3, BigDecimal> studenti3 = new HashMap<EqualsAndHashCode3, BigDecimal>();
        Map<EqualsAndHashCode4, BigDecimal> studenti4 = new HashMap<EqualsAndHashCode4, BigDecimal>();

        studenti.put(new EqualsAndHashcode("John","Popescu"), new BigDecimal(23));
        studenti.put(new EqualsAndHashcode("Marin","Gica"), new BigDecimal(23));
        studenti.put(new EqualsAndHashcode("John","Neimar"), new BigDecimal(25));
        studenti.put(new EqualsAndHashcode("Ioana","Popescu"), new BigDecimal(29));
        studenti.put(new EqualsAndHashcode("John","Popescu"), new BigDecimal(23));

        studenti2.put(new EqualsAndHashCode2("John","Popescu"), new BigDecimal(23));
        studenti2.put(new EqualsAndHashCode2("Marin","Gica"), new BigDecimal(23));
        studenti2.put(new EqualsAndHashCode2("John","Neimar"), new BigDecimal(25));
        studenti2.put(new EqualsAndHashCode2("Ioana","Popescu"), new BigDecimal(29));
        studenti2.put(new EqualsAndHashCode2("John","Popescu"), new BigDecimal(23));

        studenti3.put(new EqualsAndHashCode3("John","Popescu"), new BigDecimal(23));
        studenti3.put(new EqualsAndHashCode3("Marin","Gica"), new BigDecimal(23));
        studenti3.put(new EqualsAndHashCode3("John","Neimar"), new BigDecimal(25));
        studenti3.put(new EqualsAndHashCode3("Ioana","Popescu"), new BigDecimal(29));
        studenti3.put(new EqualsAndHashCode3("John","Popescu"), new BigDecimal(23));

        studenti4.put(new EqualsAndHashCode4("John","Popescu"), new BigDecimal(23));
        studenti4.put(new EqualsAndHashCode4("Marin","Gica"), new BigDecimal(23));
        studenti4.put(new EqualsAndHashCode4("John","Neimar"), new BigDecimal(25));
        studenti4.put(new EqualsAndHashCode4("Ioana","Popescu"), new BigDecimal(29));
        studenti4.put(new EqualsAndHashCode4("John","Popescu"), new BigDecimal(23));


        System.out.println("Lista E si H doar FirstName: ");
        Iterator it = studenti.entrySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            //it.next();
        }

        System.out.println("Lista E corect si H doar FirstName: ");
        Iterator it2 = studenti2.entrySet().iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
            //it.next();
        }


        System.out.println("Lista E doar FirstName si H corect: ");
        Iterator it3 = studenti3.entrySet().iterator();
        while (it3.hasNext()){
            System.out.println(it3.next());
            //it.next();
        }

        System.out.println("Lista corecta:");
        Iterator it4 = studenti4.entrySet().iterator();
        while (it4.hasNext()){
            System.out.println(it4.next());
            //it.next();
        }
    }
}
