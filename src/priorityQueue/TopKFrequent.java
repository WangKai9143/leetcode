package priorityQueue;

import java.util.*;

public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> ctn = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            ctn.put(words[i],ctn.getOrDefault(words[i],0) +1);
        }
        List<String> result = new ArrayList<>(ctn.keySet());
        Collections.sort(result,(String first, String second)->ctn.get(first)==ctn.get(second)?first.compareTo(second):ctn.get(second)-ctn.get(first));
        return result.subList(0,k);
    }

//    public static List<String> topKFrequent(String[] words, int k) {
//        Map<String,Integer> ctn = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            ctn.put(words[i],ctn.getOrDefault(words[i],0) +1);
//        }
//        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>((Map.Entry<String,Integer> first,Map.Entry<String,Integer> second)-> first.getValue()==second.getValue()?second.getKey().compareTo(
//                first.getKey()):first.getValue()-second.getValue());
//        for (Map.Entry<String,Integer> entry:ctn.entrySet()) {
//            priorityQueue.offer(entry);
//            if (k<priorityQueue.size()){
//                priorityQueue.poll();
//            }
//        }
//        List<String> result = new ArrayList<>();
//        while (!priorityQueue.isEmpty()){
//            result.add(priorityQueue.poll().getKey());
//        }
//        Collections.reverse(result);
//        return result;
//    }
}
