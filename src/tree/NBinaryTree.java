package tree;

import java.util.*;

/**
 * Created by Administrator on 2020/4/12.
 */
public class NBinaryTree {

    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder2(root,result);
        return result;
    }

    private void preorder2(Node root, List<Integer> result) {
        if (root == null){
            return;
        }
        List<Node> children = root.children;
        int value = root.val;
        result.add(value);
        for (Node node:children) {
            preorder2(node, result);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.val);
            // 栈是先进先出，因此需要逆反下
            Collections.reverse(node.children);
            for (Node subNode:node.children){
                stack.push(subNode);
            }
        }
        return result;
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            result.addFirst(node.val);
            for (Node subNode:node.children){
                stack.push(subNode);
            }
        }
        return result;
    }


    // Definition for a Node.
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
