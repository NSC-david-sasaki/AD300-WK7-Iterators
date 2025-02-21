package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Task 1: ArrayList Iterator");
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            arrayList.add(rand.nextInt());
        }
        arrayList.add(null);
        Iterator<Integer> iterator = arrayList.iterator();
        int tSum = 0;
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (current!=null){ // check for null values
                tSum += current;
                System.out.println("Current number: " + current);
                iterator.remove();
                try {
                    //arrayList.add(tSum); // throws ConcurrentModification Exception
                    //arrayList.remove(0); // throws ConcurrentModification Exception
                }
                catch(ConcurrentModificationException e) {
                    System.out.println("Concurrent Modification Exception"); // exception handling
                }
            }
           else{
               System.out.println("Current number is null");
            }

        }
        System.out.println("Total sum is : " + tSum);
        System.out.println("Final list: " + arrayList);

        System.out.println("Task 2 Running: HashMap Iterator\n");
        Map<String, Integer> mHashMap = new HashMap<String, Integer>() {{
            put("Books",12);
            put("Movies", 8);
            put("Music", 4);
            put("TV", 2);
            put("Theater", 10);
        }};
        Iterator<Map.Entry<String, Integer>> it2 = mHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, Integer> entry = it2.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            entry.setValue(entry.getValue() - 1);
            System.out.println("After decrement using .setValue Key: " + entry.getKey() + ", Value: " + entry.getValue());
            System.out.println("Before removal: "+mHashMap);
            it2.remove();
            System.out.println("After removal of last element "+mHashMap);
        }

        System.out.println("Task 3 Running: TreeMap Iterator\n");
        TreeMap<String, Double> temperatureMap = new TreeMap<String, Double>() {{
            put("November", null); // null value;
            put("December", -2.0); // no restriction with negative values
            put("December", 10.0); // overwrites previous value
            put("January", -12.0);
            put("February", -28.0);
            put("March", 45.0);
            put("April", 68.3);
            put("May", 68.3);
        }};
        Iterator<Map.Entry<String, Double>> it3 = temperatureMap.entrySet().iterator();

        Double tHigh = Double.NEGATIVE_INFINITY;
        Double tLow = Double.POSITIVE_INFINITY;
        List<String> tHighMonths = new ArrayList<>();
        List<String> tLowMonths = new ArrayList<>();

        while (it3.hasNext()) { // alphabetical sorting on month name as key
            Map.Entry<String, Double> entry = it3.next();
            if (entry.getValue()!=null){ // checks for null value
                if (entry.getValue() > tHigh) {
                    tHigh = entry.getValue();
                    tHighMonths.clear();
                    tHighMonths.add(entry.getKey());
                } else if (entry.getValue().equals(tHigh)) { // allows N keys with tHigh
                    tHighMonths.add(entry.getKey());
                }

                if (entry.getValue() < tLow) {
                    tLow = entry.getValue();
                    tLowMonths.clear();
                    tLowMonths.add(entry.getKey());
                } else if (entry.getValue().equals(tLow)) { // allows N keys with tLow
                    tLowMonths.add(entry.getKey());
                }
            }
            else{
                System.out.println("No value found for key: " + entry.getKey());
            }
        }
        System.out.println("Highest temp was in: " + tHighMonths + " with temp of: " + tHigh);
        System.out.println("Lowest temp was in: " + tLowMonths + " with temp of: " + tLow);
    }
}