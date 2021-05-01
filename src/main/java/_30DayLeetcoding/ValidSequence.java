package main.java._30DayLeetcoding;

/***
 * Check if string is a valid sequence from root to leaf path in a Binary Tree
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 * We get the given string from the concatenation of an array of integers arr and the
 * concatenation of all values of the nodes along a path results in a sequence in the given
 * binary tree.
 *
 * Input:
 * root = [0,1,0,0,1,0,null,null,1,0,0],
 * arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence
 * (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 */
public class ValidSequence {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return checkPath(root, arr, 0);

    }

    private boolean checkPath(TreeNode root, int[] arr, int index) {
        if (root == null || index == arr.length) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == arr[index] && index == arr.length - 1) {
            return true;
        }
        return root.val == arr[index] && (checkPath(root.left, arr, index + 1) ||
                checkPath(root.right, arr, index + 1));
    }
}
