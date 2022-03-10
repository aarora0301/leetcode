package Patterns.TreeDFS;

public class MaxPathSum {

    int max_sum = Integer.MIN_VALUE;

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);
        max_sum = Math.max(max_sum, node.val + left_gain + right_gain);
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();

        TreeNode treeNode = new TreeNode(-10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(maxPathSum.maxPathSum(treeNode));
    }

}
