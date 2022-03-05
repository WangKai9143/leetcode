package priorityQueue;

import java.util.*;

/**
 * Created by Administrator on 2020/4/2.
 */
public class TopK347 {
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < k) {
            return result;
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i],0)+1);
        }
        // 最小堆维护
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Integer o1, Integer o2)->hash.get(o1) - hash.get(o2));
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int priLen = priorityQueue.size();
            int currentkey = entry.getKey();
            int currentValue = entry.getValue();;
            if (priLen < k) {
                priorityQueue.offer(currentkey);
            } else {
                int topKey = priorityQueue.peek();
                int topValue = hash.get(topKey);
                if (currentValue > topValue) {
                    priorityQueue.poll();
                    priorityQueue.offer(currentkey);
                }
            }
        }
        result.addAll(priorityQueue);
        return result;
    }
}