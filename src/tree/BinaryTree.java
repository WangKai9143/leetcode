package tree;

import java.util.*;

/**
 * Created by Administrator on 2020/3/25.
 */

public class BinaryTree {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n <= 0 || leftChild == null || rightChild == null) {
            return false;
        }
        if (leftChild.length != rightChild.length || leftChild.length != n) {
            return false;
        }
        int degree[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                degree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                degree[rightChild[i]]++;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                root = i;
                break;
            }
        }
        // 没有根节点
        if (root == -1) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int top = queue.poll();
            if (leftChild[top] != -1) {
                if (degree[leftChild[top]] == 1) {
                    queue.offer(leftChild[top]);
                } else {
                    return false;
                }
            }
            if (rightChild[top] != -1) {
                if (degree[rightChild[top]] == 1) {
                    queue.offer(rightChild[top]);
                } else {
                    return false;
                }
            }
        }
        return count == n ? true : false;
    }


   /* 有两种通用的遍历树的策略：

    深度优先搜索（DFS）

    在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。

    深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为前序遍历，中序遍历和后序遍历。

    宽度优先搜索（BFS）

    我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。

    下图中的顶点按照访问的顺序编号，按照 1-2-3-4-5 的顺序来比较不同的策略。



    本问题就是用宽度优先搜索遍历来划分层次：[[1], [2, 3], [4, 5]]。

    作者：LeetCode
    链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    // ==========先序遍历========start
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pollLast();
            result.add(head.val);
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }
        return result;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversal2(root, result);
        return result;
    }

    private void preorderTraversal2(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if (root.left != null) {
            preorderTraversal2(root.left, result);
        }
        if (root.right != null) {
            preorderTraversal2(root.right, result);
        }
    }
    // ==========先序遍历========end


    // ==========后续遍历========start
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorderTraversal1(root, result);
        return result;
    }

    private void postorderTraversal1(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            postorderTraversal1(root.left, result);
        }
        if (root.right != null) {
            postorderTraversal1(root.right, result);
        }
        result.add(root.val);
    }

    // 后续遍历是先序遍历的倒序，因此需要倒插遍历元素
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();//最后一个元素出栈
            output.addFirst(node.val);//倒序插入
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
    // ==========后续遍历========end


    // ==========中序遍历========start
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTraversal2(root, result);
        return result;
    }

    private void inorderTraversal2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal2(root.left, result);
        result.add(root.val);
        inorderTraversal2(root.right, result);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 沿着左指针一直到没有左子树节点,均入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 出左子树节点，遍历
            curr = stack.pop();
            res.add(curr.val);
            //遍历右子树
            curr = curr.right;
        }
        return res;
    }

    // ==========后续遍历========start

    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
