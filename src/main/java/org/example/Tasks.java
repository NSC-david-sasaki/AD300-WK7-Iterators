package org.example;

import java.util.*;

public class Tasks {
    public String task1(Random rand) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(rand.nextInt()); // Use injected Random instance
        }
        arrayList.add(null);
        Iterator<Integer> iterator = arrayList.iterator();
        int tSum = 0;
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (current != null) { // Check for null values
                tSum += current;
                System.out.println("Current number: " + current);
                iterator.remove();
                try {
                    //arrayList.add(tSum); // would throw ConcurrentModificationException
                    //arrayList.remove(0); // would throw ConcurrentModificationException
                } catch (ConcurrentModificationException e) {
                    System.out.println("Concurrent Modification Exception");
                }
            } else {
                System.out.println("Current number is null");
            }
        }
        return "Total sum is : " + tSum + "\nFinal list: " + arrayList;
    }

    public String task2(){
        Map<String, Integer> mHashMap = new HashMap<String, Integer>() {{
            put("Books",12);
            put("Movies", 8);
            put("Music", 4);
            put("TV", 2);
            put("Theater", 10);
        }};
        Iterator<Map.Entry<String, Integer>> it2 = mHashMap.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it2.hasNext()) {
            Map.Entry<String, Integer> entry = it2.next();
            sb.append("Key: " + entry.getKey() + ", Value: " + entry.getValue()+"\n");
            entry.setValue(entry.getValue() - 1);
            sb.append("After decrement using .setValue Key: " + entry.getKey() + ", Value: " + entry.getValue()+"\n");
            sb.append("Before removal: "+mHashMap+"\n");
            it2.remove();
            sb.append("After removal of last element "+mHashMap+"\n");
        }
        return sb.toString();
    }
    public String task3(){
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
        StringBuilder sb = new StringBuilder();
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
                sb.append("No value found for key: " + entry.getKey()+"\n");
            }
        }
        sb.append("Highest temp was in: " + tHighMonths + " with temp of: " + tHigh+"\n");
        sb.append("Lowest temp was in: " + tLowMonths + " with temp of: " + tLow+"\n");
        return sb.toString();
    }

}
