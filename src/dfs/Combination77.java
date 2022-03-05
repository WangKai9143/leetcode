package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/10.
 */
public class Combination77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> itemResult = new ArrayList<>();
        backTracking(result,n,k,itemResult,1);
        return result;
    }

    private static void backTracking(List<List<Integer>> result, int n, int k, List<Integer> itemResult,int start) {
        if (k==0){
            result.add(new ArrayList<>(itemResult));
        }
        for (Integer i = start; i <= n; i++) {
            itemResult.add(i);
            backTracking(result, n,  k-1,   itemResult,i+1);
            itemResult.remove(i);
        }
    }
}
