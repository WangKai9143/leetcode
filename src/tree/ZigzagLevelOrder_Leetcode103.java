package tree;

import java.util.*;

public class ZigzagLevelOrder_Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight = false;
        while (!queue.isEmpty()) {
            // 双向队列
            Deque<Integer> levelList = new LinkedList<>();
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                TreeNode topNode = queue.poll();
                if (isLeftToRight) {
                    levelList.offerFirst(topNode.val);
                } else {
                    levelList.offerLast(topNode.val);
                }
                if (topNode.left!=null){
                    queue.offer(topNode.left);
                }
                if (topNode.right!=null){
                    queue.offer(topNode.right);
                }
            }
            result.add(new ArrayList<Integer>(levelList));
            isLeftToRight=!isLeftToRight;
        }
        return result;
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
