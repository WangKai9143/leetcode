package slidingWindow;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class ContainsNearbyAlmostDuplicate220 {
    // 暴力法
   /* public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long) nums[j] - (long) nums[k]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }*/

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Deque<Integer> window = new LinkedList<>();
        long result = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            window.offerLast(nums[i]);
            // 维护固定窗口大小
            if (window.size() > k + 1) {
                window.pollFirst();
            }
            for (int j = 1; j < window.size(); j++) {
                long diff = java.lang.Math.abs((long) nums[i] - (long) nums[i - j]);
                if (diff <= t && diff < result) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    void testContainsNearbyAlmostDuplicate() {
//        int[] nums = {1, 2, 3, 1};
//        int k = 3, t = 0;

//        int[] nums = {1, 0, 1, 1};
//        int k = 1, t = 2;

//        int [] nums = {1,5,9,1,5,9};
//        int k = 2, t = 3;


        int[] nums = {-2147483648, 2147483647};
        int k = 1, t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
