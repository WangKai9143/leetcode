package arr;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNum1 {
    /**
     * 暴力 枚举法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length ==0){
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 查找表法，记录元素位置，省去一层便利
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length ==0){
            return new int[0];
        }
        Map<Integer,Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           if (integerMap.containsKey(target-nums[i])){
                return new int[]{integerMap.get(target),i};
           }
           integerMap.put(nums[i],i);
        }
        return new int[0];
    }

}
