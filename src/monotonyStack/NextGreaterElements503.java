package monotonyStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements503 {
    // 循环队列展开 一个朴素的思想是，我们可以把这个循环数组「拉直」，即复制该序列的前 n-1,
    // n−1 个元素拼接在原序列的后面。这样我们就可以将这个新序列当作普通序列，然后用单调栈的方法处理。
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        Stack<Integer> stack = new Stack();
        int [] result = new int [nums.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < 2* nums.length-1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]){
                int top = stack.pop();
                result[top] = nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return result;
    }
}
