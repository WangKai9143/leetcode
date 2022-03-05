package tree;

/**
 * Created by Administrator on 2020/4/13.
 */
public class SumPath {

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int height = getHeight(root);
        int [] path = new int[height];
        int [] maxSum = new int [1];
        getNumberPath(root, maxSum, path, 0);
        return path[0];
    }

    // 精髓在于维护了一个路径数组，每行某时间只保存一个数字
    private void getNumberPath(TreeNode root, int [] maxSum, int[] path, int level) {
        if (root == null) {
            return;
        }
        path[level] = root.val;
        int curSum = 0;
        // 从当前节点到根节点遍历
        for (int i = level; i >= 0; i--) {
            curSum += path[i];
            if (curSum > maxSum[0]) {
                maxSum[0] = curSum;
            }
        }
        if (root.left != null) {
            getNumberPath(root.left, maxSum, path, level + 1);
        }
        if (root.right != null) {
            getNumberPath(root.right, maxSum, path, level + 1);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
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
