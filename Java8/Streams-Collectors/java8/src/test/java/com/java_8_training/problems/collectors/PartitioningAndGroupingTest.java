package com.java_8_training.problems.collectors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.java_8_training.problems.collectors.Dish.CaloricLevel;
import static com.java_8_training.problems.collectors.Dish.menu;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static junit.framework.Assert.assertEquals;

@Ignore
public class PartitioningAndGroupingTest {

    // See: Dish.menu.stream()
    // Partition the menu with dishes > 380
    @Test
    public void partitionDishes() {

        Map<Boolean, List<Dish>> partitionedDishes = new HashMap<>();

        partitionedDishes = menu.stream().collect(partitioningBy(dish -> (dish.getCalories() > 380)));

        //TODO #C1
        assertEquals(2, partitionedDishes.get(false).size());
        assertEquals(7, partitionedDishes.get(true).size());
    }

    // Group the list of dishes by caloric level
    @Test
    public void groupDishes() {
        Map<CaloricLevel, List<Dish>> groupedDishes = new HashMap<>();

        //TODO #C2

        groupedDishes = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET; else if
            (400 < dish.getCalories() && dish.getCalories() <= 700) return CaloricLevel.NORMAL; else return CaloricLevel.FAT;
        }));
//
        assertEquals(4, groupedDishes.get(CaloricLevel.DIET).size());
        assertEquals(4, groupedDishes.get(CaloricLevel.NORMAL).size());
        assertEquals(1, groupedDishes.get(CaloricLevel.FAT).size());
    }

    @Test
    public void groupCounting(){
       // Map<Dish.Type, Long> groupedDishes = Dish.menu.stream().filter(dish -> (dish.getCalories() >140)).collect(groupingBy(Dish::getType.counting()));
        //TODO #C7



        //assertEquals(3, groupedDishes.get(Dish.Type.MEAT).intValue());
        //assertEquals(2, groupedDishes.get(Dish.Type.FISH).intValue());
        //assertEquals(3, groupedDishes.get(Dish.Type.OTHER).intValue());
    }

}
