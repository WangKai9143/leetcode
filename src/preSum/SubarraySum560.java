package preSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
    // 暴力法
/*    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }*/

/*    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum []  = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] += preSum[i]+nums[i];
        }
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (preSum[right+1] - preSum[left] == k){
                    count++;
                }
            }
        }
        return count;
    }*/


    /*
    pre[i]=pre[i−1]+nums[i]

    那么[j..i]这个子数组和为 k 这个条件我们可以转化为
    pre[i]−pre[j−1]==k(j...i区间和为k)

    简单移项可得符合条件的下标 j 需要满足
    pre[j−1]==pre[i]−k
*/
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int num:nums) {
            preSum+=num;
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumMap.containsKey(preSum-k)){
                count+=preSumMap.get(preSum-k);
            }
            preSumMap.put(preSum,preSumMap.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
