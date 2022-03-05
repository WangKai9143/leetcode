package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/10.
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates,target);

        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
/**  这种遍历关系
      1
    / \ \
    2 3 4
   //\ /\ \
  2 3 4 3 4 4
 **/
    // 层次的开始位置成递增关系，保证了每组元素的顺序性，唯一性
    private static void dfs(int start,int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i]<=target){
                path.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                dfs(i,candidates, target-candidates[i], path, result);
                path.remove(path.size()-1);
            }
        }
    }

    // 这里注意如果使用 for (int i = 0; i < candidates.length; i++) dfs，下图中1 1 2和2 1 1重复
    //    1     2     3
    //  1 2 3  1 2 3 1 2 3
    //1 2 3...
    // 当dfs为两层,和下面这个循环类似
    //            for (int i = 0; i < nums.length; i++) {
    //        for (int j = 0; j < nums.length; j++) {

    //但是如果使用for (int i = start; i < candidates.length; i++) dfs, 效果
    //      1       2         3
    //   1  2  3   2  3       3
    //1 2 3 2 3 3 2 3...
    // 当dfs为两层,和下面这个循环类似
//            for (int i = 0; i < nums.length; i++) {
//        for (int j = i; j < nums.length; j++) {
}
