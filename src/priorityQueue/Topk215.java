package priorityQueue;

import java.util.*;

public class Topk215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        // 最小堆维护
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer obj : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(obj);
            } else {
                if (obj > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(obj);
                }
            }
        }
        return priorityQueue.peek();
    }
}
