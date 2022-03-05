package str;

import java.util.Stack;

/**
 * Created by Administrator on 2020/5/2.
 */
public class LeetCode1003 {
    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));
    }
//    public static boolean isValid(String S) {
//        if (S == null){
//            return false;
//        }
//        while (!S.isEmpty() && S.contains("abc")){
//            S = S.replaceAll("abc","");
//        }
//        return S.isEmpty();
//    }


    // 和括号匹配是一个思想，进栈所有元素，遇到一个元素，必须出一个元素
    public static boolean isValid(String S) {
        if (S == null){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'c'){
                if (stack.isEmpty() || stack.pop() != 'b'){
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a'){
                    return false;
                }
            }else {
                stack.push(S.charAt(i));
            }

        }
        return stack.isEmpty();
    }
}
