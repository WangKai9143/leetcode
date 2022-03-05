package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2020/3/23.
 */
public class LevelTraversal_II {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(levelOrderBottom(node1));
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);
        levelOrderBottom(result, levelList);
        return result;
    }

    private static void levelOrderBottom(List<List<Integer>> result, List<TreeNode> levelList) {
        List<Integer> levelResult = new ArrayList<>(); // 当前层结果
        List<TreeNode> treeNodes = new ArrayList<>(); // 下一层要便利的节点
        for (TreeNode treeNode : levelList) {
            if (treeNode.left == null && treeNode.right == null) { // 为叶子节点，在当前层结果加入
                levelResult.add(treeNode.val);
            }
            if (treeNode.left != null) { // 加入左节点
                treeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) { // 加入右节点
                treeNodes.add(treeNode.right);
            }
        }
        // 如果都是叶子节点，递归返回上一层
        if (levelResult.size() == levelList.size()) {
            result.add(levelResult);
            return;
        }else{
            levelOrderBottom(result, treeNodes);
            // 不加的话，清空结果集
            List<Integer> levelResult2= new ArrayList<>(); // 当前层结果
            for (TreeNode treeNode : levelList) {
                levelResult2.add(treeNode.val);
            }
            result.add(levelResult2);
        }
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
