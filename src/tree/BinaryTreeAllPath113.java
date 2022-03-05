package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
public class BinaryTreeAllPath113 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        getAllTreePaths(root, "", allPaths);
        return allPaths;
    }

    private void getAllTreePaths(TreeNode root, String s, List<String> allPaths) {
        if (root == null) {
            return;
        }
        s += root.val;
        if (root.left == null && root.right == null) {
            allPaths.add(s);
        } else {
            s += "->";
            getAllTreePaths(root.left, s, allPaths);
            getAllTreePaths(root.right, s, allPaths);
        }

    }

    public static void main(String[] args) {
        System.out.println(hasPathSum(new TreeNode(1),0));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            boolean leftResult = false;
            boolean rightResult = false;
            if (root.left != null) {
                 leftResult =  hasPathSum(root.left, sum);
            }
            if (root.right != null) {
                rightResult =  hasPathSum(root.right, sum);
            }
            return leftResult || rightResult;
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
