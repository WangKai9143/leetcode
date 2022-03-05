package other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/12.
 */
public class BracketsProduct {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        String str = "";
        dfs(0, 0, n, str, list);
        return list;
    }

    static void dfs(int left, int right, int n, String str, List<String> list) {
        if (left == n && right == n) {
            list.add(str);
        }
        // 先绑定左括号，再绑定右括号
        if (left < n) {
            dfs(left + 1, right, n, str + '(', list);
        }
        // 左括号个数一定多余右括号，才是有效括号
        if (left > right) {
            dfs(left, right + 1, n, str + ')', list);
        }
    }

}
