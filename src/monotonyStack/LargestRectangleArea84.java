package monotonyStack;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
public class LargestRectangleArea84 {
    // 暴力法
/*    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            // 左边找第一个小于当前高度
            while (left>0 && heights[left-1]>=heights[i]){
                left--;
            }
            int right = i;
            while (right< heights.length-1 && heights[right+1]>=heights[i]){
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }*/

    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
    // 维护一个递增栈,找到一个比栈顶元素小的，出栈计算面积
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[0] = 0;
        newHeight[heights.length + 1] = 0;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < newHeight.length; i++) {
            // 遍历递增序列中每个高度的面积
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * newHeight[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    @Test
    void largestRectangleArea() {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
