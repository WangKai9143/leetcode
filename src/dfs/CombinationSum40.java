package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/10.
 */
public class CombinationSum40 {
    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates,target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return result;
        }
        // 排序是为了提前终止搜索
        Arrays.sort(candidates);
        List<Integer> path = new LinkedList<>();
        dfs(0,candidates, target,  path, result);
        return result;
    }

    private static void dfs(int start,int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 数组常见去重复的方法，对于重复的数值，我们只让第一个进入循环，后面的就不要再进入循环了
            if (i>start && candidates[i-1] == candidates[i]){
                continue;
            }
            if (candidates[i]<=target){
                path.add(candidates[i]);
                //因为每个数字不能重复，所以递归还可以从下一个元素开始
                dfs(i+1,candidates, target-candidates[i], path, result);
                path.remove(path.size()-1);
            }
        }
    }

}
