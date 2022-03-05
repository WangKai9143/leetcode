package recursion;

import java.util.ArrayList;
import java.util.List;

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

public class ExcellentPermutation {
    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }

    public static int countArrangement(int N) {
        if (N <= 0) {
            return 0;
        }
        int[] arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        int result = 0;
        List<Integer> list = new ArrayList<>();
        list.add(result);
        // permatiton(arr, 1, 0, list);
        // permatiton2(arr, 1, 0, list);
        boolean[] visited = new boolean[N + 1];
        permatiton3(arr, 1, list, visited);
        return list.get(list.get(list.size() - 1));
    }

    public static void permatiton(int[] arr, int start, int result, List<Integer> list) {
        if (start == arr.length - 1) {
            int i;
            for (i = 1; i < arr.length; i++) {
                if (arr[i] % i != 0 && i % arr[i] != 0) {
                    break;
                }
            }
            if (i == arr.length) {
                int len = list.size() - 1;
                int count = list.get(len);
                list.add(++count);
            }
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permatiton(arr, start + 1, result, list);
            swap(arr, start, i);
        }
    }

    // 提交减枝
    public static void permatiton2(int[] arr, int start, int result, List<Integer> list) {
        if (start == arr.length) {
            int len = list.size() - 1;
            int count = list.get(len);
            list.add(++count);
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            if (arr[start] % start == 0 || start % arr[start] == 0) {
                permatiton2(arr, start + 1, result, list);
            }
            swap(arr, start, i);
        }
    }

    // 回溯法

    /**
     * 这个方法背后的想法很简单。我们常数从 1 到 N 创建所有的排列。我们可以将一个数字放在一个特定位置并检查这个数字在这个位置的可除性。但我们还需要记录之前已经使用过哪些数字以免重复使用同一个数字。如果当前数字不能满足可除性要求，当前位置为这个数的所有排列我们就都不需要考虑了，这个剪枝可以让我们的搜索空间大大减少。我们通过将每个数字在每个位置进行检查来实现这一过程。

     我们使用一个使用一个大小为 NN 的 “已使用数组” ，这里 visited[i]visited[i] 表示目前为止第 ii 个数字是否已经使用过，True 表示已经使用过， False 表示还没有使用过。

     我们使用函数 calculate，它将从 1 到 N 所有还没有被使用过的数字放到当前位置 pospos，并检查是否满足可除性。如果 ii 放到当前位置 pospos 是满足要求的，我们就把 ii 放在当前位置 pospos 并继续考虑下一个位置 pos + 1pos+1，否则我们需要换一个数字放在当前位置。
     * @param arr
     * @param pos
     * @param list
     * @param visited
     */
    public static void permatiton3(int[] arr, int pos, List<Integer> list, boolean[] visited) {
        if (pos == arr.length) {
            int len = list.size() - 1;
            int count = list.get(len);
            list.add(++count);
        }
        for (int i = 1; i < arr.length; i++) {
            // 顺序固定某个位置
            if ((arr[i] % pos == 0 || pos % arr[i] == 0) && !visited[i]) {
                visited[i] = true;
                permatiton3(arr, pos + 1, list, visited);
                visited[i] = false;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
