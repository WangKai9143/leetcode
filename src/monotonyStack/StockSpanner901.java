package monotonyStack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
public class StockSpanner901 {
    List<Integer> list = null;
    Deque<Integer> stack = null;

    public StockSpanner901() {
        list = new ArrayList<>();
        stack = new LinkedList<>();
    }

    // 维护一个单调递减栈
    // 单调递减序列，保证了出栈的元素，肯定不影响当前元素之后，新入的元素的结果
    // 如果后入元素比当前元素大或者等于，则已经出的元素肯定不是后入元素要找的比他大的元素。
    // 如果后入元素比当前元素小，则结果为1
    public int next(int price) {
        int res = 0;
        list.add(price);
        // 第一个大于当前价格的位置
        while (!stack.isEmpty() && list.get(stack.peek())<=price){
            stack.pop();
        }
        if (stack.isEmpty()){
            res =  list.size();
        }else{
            res = list.size() - 1 - stack.peek();
        }
        stack.push(new Integer(list.size() - 1));
        return res;
    }
}


