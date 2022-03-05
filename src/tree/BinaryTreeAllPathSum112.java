package tree;

import java.util.*;

/**
 * Created by Administrator on 2020/4/10.
 */
public class BinaryTreeAllPathSum112 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;

        System.out.println(pathSum(node1, 22));

    }

    // 利用bfs
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        queue.add(path);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<TreeNode> tmpPath = queue.poll();
                TreeNode tmpNode = tmpPath.get(tmpPath.size() - 1);
                if (tmpNode.left == null && tmpNode.right == null) {
                    int total = 0;
                    List<Integer> tmpResult = new ArrayList<>();
                    for (int j = 0; j < tmpPath.size(); j++) {
                        tmpResult.add(tmpPath.get(j).val);
                        total+=tmpPath.get(j).val;
                    }
                    if (total == sum) {
                        result.add(tmpResult);
                    }
                }
                if (tmpNode.left != null) {
                    tmpPath.add(tmpNode.left);
                    queue.add(new ArrayList<>(tmpPath));
                    tmpPath.remove(tmpPath.size() - 1);
                }
                if (tmpNode.right != null) {
                    tmpPath.add(tmpNode.right);
                    queue.add(new ArrayList<>(tmpPath));
                    tmpPath.remove(tmpPath.size() - 1);
                }
            }
        }
        return result;
    }



/*   public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getAllTreePaths1(root, 0, allPaths, sum, tmp);
        return allPaths;
    }

    private static void getAllTreePaths1(TreeNode root, int s, List<List<Integer>> allPaths, int sum, List<Integer> tmp) {
        if (root == null){
            return;
        }
        s += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null && s == sum) {
            allPaths.add(new ArrayList<>(tmp)); // 注意需要重新生成对象，不然在全局遍历一个对象
        } else {
            getAllTreePaths1(root.left, s, allPaths, sum, tmp);
            getAllTreePaths1(root.right, s, allPaths, sum, tmp);
        }
        tmp.remove(tmp.size()-1);
    }*/

    /*
    private static void getAllTreePaths(TreeNode root, List<List<Integer>> allPaths, int sum, List<Integer> tmp) {
        if (root == null){
            return;
        }
        sum -= root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null && 0 == sum) {
            allPaths.add(new ArrayList<>(tmp)); // 注意需要重新生成对象，不然在全局遍历一个对象
        } else {
            getAllTreePaths(root.left, allPaths, sum, tmp);
            getAllTreePaths(root.right, allPaths, sum, tmp);
        }
        tmp.remove(tmp.size()-1);

    }
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
