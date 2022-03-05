package monotonyStack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

        示例 1:

        输入: temperatures = [73,74,75,71,69,72,76,73]
        输出: [1,1,4,2,1,1,0,0]
        示例 2:

        输入: temperatures = [30,40,50,60]
        输出: [1,1,1,0]
        示例 3:

        输入: temperatures = [30,60,90]
        输出: [1,1,0]
。*/
public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        // 递减栈
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        // 没有遇到满意的，就一直进栈，一遇到满意的，看看栈里面的兄弟是否满足要求
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        return result;
    }

    @Test
    void testDailyTemperatures() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }
}
