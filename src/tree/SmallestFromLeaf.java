package tree;

/**
 * Created by Administrator on 2020/4/15.
 */
public class SmallestFromLeaf {

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(25);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(smallestFromLeaf(node0));

    }
    public static String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        String[] target = new String[1];
        getSmallestFromLeaf(root, "", target);
        return target[0];
    }

    private static void getSmallestFromLeaf(TreeNode root, String s, String[] target) {
        s = (char)(root.val +'a') + s;
        if (root.left == null && root.right == null) {
            if (target[0] == null || target[0].isEmpty() || target[0].compareTo(s)>0) { //字典序就是字符中比较
                target[0] = s;
            }
        }
        if (root.left != null) {
            getSmallestFromLeaf(root.left, s, target);
        }
        if (root.right != null) {
            getSmallestFromLeaf(root.right, s, target);
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
