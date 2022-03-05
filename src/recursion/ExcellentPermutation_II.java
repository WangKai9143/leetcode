package recursion;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by Administrator on 2020/3/22.
 */

/*526. 优美的排列
        假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

        第 i 位的数字能被 i 整除
        i 能被第 i 位上的数字整除
        现在给定一个整数 N，请问可以构造多少个优美的排列？

        示例1:

        输入: 2
        输出: 2
        解释:

        第 1 个优美的排列是 [1, 2]:
        第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
        第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

        第 2 个优美的排列是 [2, 1]:
        第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
        第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
        说明:

        N 是一个正整数，并且不会超过15。*/

public class ExcellentPermutation_II {
    public static void main(String[] args) {
        System.out.println(constructArray(3, 2));
    }

    public static int[] constructArray(int n, int k) {
        int[] result = new int[0];
        if (n <= 0) {
            return result;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        permatiton(arr, 0, k, list);
        return list.size() == 0 ? result : list.get(0);
    }

    // 回溯法

    /**
     * 这个方法背后的想法很简单。我们常数从 1 到 N 创建所有的排列。我们可以将一个数字放在一个特定位置并检查这个数字在这个位置的可除性。但我们还需要记录之前已经使用过哪些数字以免重复使用同一个数字。如果当前数字不能满足可除性要求，当前位置为这个数的所有排列我们就都不需要考虑了，这个剪枝可以让我们的搜索空间大大减少。我们通过将每个数字在每个位置进行检查来实现这一过程。
     * <p>
     * 我们使用一个使用一个大小为 NN 的 “已使用数组” ，这里 visited[i]visited[i] 表示目前为止第 ii 个数字是否已经使用过，True 表示已经使用过， False 表示还没有使用过。
     * <p>
     * 我们使用函数 calculate，它将从 1 到 N 所有还没有被使用过的数字放到当前位置 pospos，并检查是否满足可除性。如果 ii 放到当前位置 pospos 是满足要求的，我们就把 ii 放在当前位置 pospos 并继续考虑下一个位置 pos + 1pos+1，否则我们需要换一个数字放在当前位置。
     *
     * @param arr
     * @param pos
     * @param list
     */
    public static void permatiton(int[] arr, int pos, int k, List<int[]> list) {
        if (pos >= arr.length -1) {
            Map<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i + 1 < arr.length; i++) {
                int tmp = Math.abs(arr[i] - arr[i + 1]);
                if (map.get(tmp) == null || !map.get(tmp)) {
                    map.put(tmp, true);
                }
            }
            if (map.size() == k) {
                int[] result = Arrays.copyOf(arr, arr.length);
                list.add(result);
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 顺序固定某个位置
            swap(arr, pos, i);
            permatiton(arr, pos + 1, k, list);
            swap(arr, pos, i);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
