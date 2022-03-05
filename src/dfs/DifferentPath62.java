package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/19.
 */
public class DifferentPath62 {


    public static void main(String[] args) {
        DifferentPath62 differentPath62 = new DifferentPath62();
        System.out.println(differentPath62.uniquePaths(3, 7));
    }

    List<List<int[]>> result = new ArrayList<>();

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        List<int[]> path = new ArrayList<>();
        dfs(0, 0, m, n, path);
        return result.size();
    }

    // 因为方向只能向前，不用回溯
    private void dfs(int x, int y, int m, int n, List<int[]> path) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        path.add(new int[]{x, y});
        if (x == m - 1 && y == n - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        dfs(x, y + 1, m, n, path);
        dfs(x + 1, y, m, n, path);
        path.remove(path.size() - 1);
    }
}
