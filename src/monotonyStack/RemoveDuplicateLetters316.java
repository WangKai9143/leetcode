package monotonyStack;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i),countMap.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);
            if (stack.contains(s.charAt(i))){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > s.charAt(i)) {
                if (countMap.get(stack.peek())==0) {
                    break;
                }
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    @Test
    void testRemoveDuplicateLetters() {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
