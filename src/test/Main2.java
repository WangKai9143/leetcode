package test;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(1);
//        priorityQueue.add(4);
//        priorityQueue.add(2);
//        priorityQueue.add(3);
//
//        System.out.println(priorityQueue);
//        priorityQueue.add(-1);
//        System.out.println(priorityQueue);
//        priorityQueue.add(2);
//        System.out.println(priorityQueue);
//        priorityQueue.add(-2);
//        System.out.println(priorityQueue);
//        priorityQueue.remove(-2);
//        System.out.println(priorityQueue);

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(3);
        System.out.println(set);
        set.remove(2);
        System.out.println(set);
        set.add(-1);
        System.out.println(set);


        TreeMap<String,Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        map.put("1",1);
        map.put("3",3);
        map.put("2",2);
        map.put("4",4);
        System.out.println(map.keySet());
        map.remove("2");
        System.out.println(map.keySet());
        map.put("-1",-1);
        System.out.println(map.keySet());
        
    }
}
