package tree;

/**
 * Created by Administrator on 2020/4/13.
 */
public class MaxSumPath {

    public int maxPathSum(TreeNode root,int [] maxResult) {
        if (root == null){
            return 0;
        }
        int leftMaxSum = Math.max(maxPathSum(root.left,maxResult),0);
        int rightMaxSum = Math.max(maxPathSum(root.right,maxResult),0);
        //更新路径和，左节点-->根节点-->右节点
        int maxSum = root.val+leftMaxSum+rightMaxSum;
        if (maxSum>maxResult[0]){
            maxResult[0] = maxSum;
        }
        // 返回的是左节点到根节点的路径和
        return root.val+Math.max(leftMaxSum,rightMaxSum);
    }


    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int result [] = {Integer.MIN_VALUE};
        maxPathSum(root,result);
        return result[0];
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
