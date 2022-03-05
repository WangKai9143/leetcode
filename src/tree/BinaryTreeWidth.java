package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2020/3/25.
 */
public class BinaryTreeWidth {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();// 存储索引，用索引来计算宽度
        queue.offer(root);
        indexList.add(1);
        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int index = indexList.removeFirst();
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    indexList.add(2 * index);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexList.add(2 * index + 1);
                }
            }
            // 计算下一层的宽度
            if (indexList.size() >= 2) {
                maxWidth = Math.max(indexList.getLast() - indexList.getFirst() + 1, maxWidth);
            }
        }
        return maxWidth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
