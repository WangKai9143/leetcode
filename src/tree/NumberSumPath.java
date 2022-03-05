package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/15.
 */
public class NumberSumPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;

        System.out.println(sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> allNumber = new LinkedList<>();
        getAllNumber(root,allNumber,"");
        int sum = 0;
        for (String obj:allNumber) {
            sum+=Integer.valueOf(obj);
        }
        return sum;
    }

    private static void getAllNumber(TreeNode root, List<String> allNumber, String s) {
        s+=root.val;
        if (root.left == null && root.right == null){
            allNumber.add(new String(s));
        }
        if (root.left!=null){
            getAllNumber(root.left, allNumber, s);
        }
        if (root.right!=null){
            getAllNumber(root.right, allNumber, s);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
