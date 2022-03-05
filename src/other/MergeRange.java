package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/7.
 */

/*56. 合并区间
        给出一个区间的集合，请合并所有重叠的区间。

        示例 1:

        输入: [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        示例 2:

        输入: [[1,4],[4,5]]
        输出: [[1,5]]
        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。*/
public class MergeRange {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length ==0) {
            return new int[0][0];
        }
        // 先按照每个元素的第一个数字对数组进行排序
        Arrays.sort(intervals, (inter1, inter2) -> inter1[0] == inter2[0] ? inter2[0] - inter1[0] : inter1[0] - inter2[0]);
        int maxLeft = intervals[0][0];
        int maxRight = intervals[0][1];
        List<int[]> mergeRanges = new ArrayList<>();//，重要,无论是几位数组，对List来说就是一位数组，一个地址而已
        int i = 0;
        while (i < intervals.length) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            // 更新右边值
            if (curLeft <= maxRight) {
                maxRight = Math.max(maxRight, curRight);
            } else {
                // 组建新区间，才保存旧区间到结果集，虽然实际是个二维数组，但对于集合就是一个地址
                mergeRanges.add(new int []{maxLeft,maxRight});// 遍历到最后一个元素到这，必然将最后一个元素之前的结果先存入结果集，不会出现最后一个元素重复到结果集中
                maxLeft = intervals[i][0];
                maxRight = intervals[i][1];
            }
            i++;
        }
        // 处理最后一个节点，虽然实际是个二维数组，但对于集合就是一个地址
        mergeRanges.add(new int []{maxLeft,maxRight});
        // list转二维数组,这个也比较难
        int[][] res = new int[mergeRanges.size()][2];
        mergeRanges.toArray(res);
        return res;
    }
}

