package monotonyStack;

import java.util.Stack;

public class FinalPrices1475 {
    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[prices.length];
        System.arraycopy(prices, 0, result, 0, prices.length);
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int top = stack.pop();
                result[top] = result[top] - result[i];
            }
            stack.push(i);
        }
        return result;
    }
}
