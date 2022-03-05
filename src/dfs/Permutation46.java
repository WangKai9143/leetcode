package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result, nums, 0);
        return result;
    }

    private static void backTracking(List<List<Integer>> result, int[] nums, int level) {
        if (level == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tmp.add(nums[i]);
            }
            result.add(tmp);
        }
        // 调换位置后，递归求子问题
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            backTracking(result, nums, level + 1);
            swap(nums, i, level);
        }
    }

    private static void swap(int[] nums, int level, int i) {
        int tmpVar = nums[i];
        nums[i] = nums[level];
        nums[level] = tmpVar;
    }
}
