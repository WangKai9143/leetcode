package recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/11.
 */
/*面试题 08.07. 无重复字符串的排列组合
        无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

        示例1:

        输入：S = "qwe"
        输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
        示例2:

        输入：S = "ab"
        输出：["ab", "ba"]
        提示:

        字符都是英文字母。
        字符串长度在[1, 9]之间。*/
public class Permutation {
    public static void main(String[] args) {
        String [] result = permutation("qwe");
        System.out.println(result.toString());
    }


    public static String[] permutation(String S) {
        if (S == null || S.isEmpty()) {
            return new String[0];
        }
        char[] chs = S.toCharArray();
        List<String> list = new LinkedList<>();
        nextPermutation(chs, 0, list);
        String [] result = new String[list.size()];
        return list.toArray(result);

    }

    // 不能递归合并字符串，所以考虑换数组中字符的位置，恢复字符的位置
    public static void nextPermutation(char[] chs, int start, List<String> list) {
        if (start >= chs.length) {
            list.add(new String(chs));
            return;
        }
        for (int i = start; i < chs.length; i++) {
            // 第一个值可能为所有元素
            swap(chs, i, start);
            nextPermutation(chs, start + 1, list);
            // 固定完第一个值再恢复原序列，让其他元素做第一个值
            swap(chs, i, start);
        }
    }

    public static void swap(char[] cs, int i, int j){
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
}
