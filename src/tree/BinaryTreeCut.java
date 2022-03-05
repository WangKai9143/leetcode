package tree;

/**
 * Created by Administrator on 2020/3/27.
 */
public class BinaryTreeCut {

    public static TreeNode pruneTree(TreeNode root) {
         binaryTreeCut(root);
         return root;
    }

    public static boolean binaryTreeCut(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean leftResult = binaryTreeCut(root.left);

        boolean rightResult = binaryTreeCut(root.right);

        if (!leftResult) {
            root.left = null;
        }
        if (!rightResult) {
            root.right = null;
        }
        return leftResult || rightResult || root.val==1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
