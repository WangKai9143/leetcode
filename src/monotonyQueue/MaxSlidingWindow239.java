package monotonyQueue;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MaxSlidingWindow239 {

    // 使用单调对接解决滑动窗口最值问题，保持队列单调递减，包括去尾（当前元素大于队尾） 去头（队列大小大于k）动作
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i+1 >= k) {// 这块需要注意
                while (!deque.isEmpty() && deque.peekFirst() < i+1 - k) {// 这块需要注意
                    deque.pollFirst();
                }
                result.add(nums[deque.peekFirst()]);
            }
        }
        int arr[] = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    @Test
    void testMaxSlidingWindow() {
        // System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
