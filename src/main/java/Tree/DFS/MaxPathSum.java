package main.java.Tree.DFS;

public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return maxSum;
    }

    private int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(traversal(root.left), 0);
        int right = Math.max(traversal(root.right), 0);
        int dummy = root.val + left + right;
        maxSum = Math.max(maxSum, dummy);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxPathSum test = new MaxPathSum();
        int res = test.maxPathSum(root);
        System.out.println(res);
    }
}
