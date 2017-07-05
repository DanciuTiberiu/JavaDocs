package exercise.exercise0;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){
    }

    public void iterateThroughList(){
        ArrayList<Integer> partList = new ArrayList();
        int i;
        for (i=0; i<12; i++){
            partList.add(i);
        }

        System.out.println("Iteration with ListIterator: ");
        ListIterator<Integer> it = partList.listIterator() ;
        while (it.hasNext()){
            System.out.println(it.next() + "," + it.nextIndex() + "," + it.previousIndex() + ";");
            System.out.println();
        }

        System.out.println("Iteration with for: ");
        System.out.println();

        for (i=0; i<12; i++){
            System.out.println(partList.get(i));
        }

        System.out.println("Iteration with foreach: ");
        System.out.println();

        for (Integer elem: partList
             ) {
            System.out.println(elem);
        }


        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 instance = new Exercise0();
        instance.iterateThroughList();
    }
}
