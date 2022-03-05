package dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permute47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(result, tmp, nums, visited, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] visited, int start) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            backtracking(result, tmp, nums, visited, start + 1);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    @Test
    void testPermuteUnique() {
        List<List<Integer>> result = permuteUnique(new int[]{1, 1, 2});
    }
}
