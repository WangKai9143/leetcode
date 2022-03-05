package tree;

/**
 * Created by Administrator on 2020/4/17.
 */
public class SumPath_III {
    public static void main(String[] args) {
        //root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node4.left = node7;
        node4.right = node8;

        node5.right = node9;

        System.out.println(pathSum(node1, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int [] count = {0};
        int height = getHeight(root);
        int [] path = new int[height];
        getPathSum(root,sum,count,path,0);
        return count[0];
    }

    // 不过搜索方式改变为，把每个遍历到的节点当作终点（路径必须包含终点），记录根到终点的路径，从路径往前搜索
    private static void getPathSum(TreeNode root, int sum, int[] count,int [] path, int level) {
        path[level] = root.val;
        int currentSum = 0;
        // 从后面节点向根节点遍历
        for (int i = level; i >=0 ; i--) {
            currentSum += path[i];
            if (currentSum == sum) {
                count[0] += 1;
            }
        }
        if (root.left != null) {
            getPathSum(root.left, sum,count, path, level + 1);
        }
        if (root.right != null) {
            getPathSum(root.right, sum,count, path, level + 1);
        }
    }


    private  static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
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
