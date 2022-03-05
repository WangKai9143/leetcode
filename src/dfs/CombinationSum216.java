package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/10.
 */
public class CombinationSum216 {
    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3,9);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k<=0 || n<=0){
            return result;
        }
        List<Integer> path = new LinkedList<>();
        dfs(k, n , path, result,1);
        return result;
    }

    // 层次的开始位置成递增关系，保证了每组元素的顺序性，唯一性
    private static void dfs(int k, int n, List<Integer> path, List<List<Integer>> result,int start) {
        if (k == 0){
            if (n == 0){
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (!path.contains(i) && i<=n){
                path.add(i);
                dfs(k - 1, n - i, path, result,i);
                path.remove(path.size()-1);
            }
        }
    }

}
