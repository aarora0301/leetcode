package main.java._30DayLeetcoding;

/***
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections. The path must contain
 * at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * visualisation: https://www.youtube.com/watch?v=_wUz0XKQ5JM
 */
public class MaxPathSum {


    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateSum(root);
        return max;
    }

    int calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateSum(root.left);
        int right = calculateSum(root.right);
        /**
         * If path goes through root
         */
        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
        /***
         * If path doesn't go through root
         */
        max = Math.max(max, Math.max(current, left + right + root.val));
        return current;
    }

    public static void main(String[] args) {
        MaxPathSum test = new MaxPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        test.maxPathSum(root);
    }
}
