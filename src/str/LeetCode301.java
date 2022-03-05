package str;

import java.util.*;

/**
 * Created by Administrator on 2020/5/8.
 */
public class LeetCode301 {
    public static void main(String[] args) {
        List<String> result =  removeInvalidParentheses("()())()");
        System.out.println(result);
    }
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null){
            return result;
        }
        Set<String> set = new HashSet<>();
        set.add(s);
        while (!set.isEmpty()){
            boolean flag = false;
            int len = set.size();
            for (String str: set) {
                if (isvalidParentheses(str)){
                    flag = true;
                    result.add(str);
                }
            }
            if (flag){
                break;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str: set) {
                for (int j = 0; j < str.length(); j++) {
                    nextSet.add(str.substring(0, j)+str.substring(j + 1));
                }
            }
            set = nextSet;
        }
        return result;
    }

    static boolean  isvalidParentheses(String str){
        if (str == null){
            return false;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                count++;
            }
            else if (str.charAt(i) == ')') {
                count--;
                if (count < 0){
                    return false;
                }
            }
        }
        return count==0;
    }
}
