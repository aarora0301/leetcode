package main.java.May_LeetCodingChallenge.Week4;

/***
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val,
 * and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node
 * first, then traverses node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * The values of preorder are distinct.
 */


public class BSTFromPreorder {
    TreeNode head;

    public TreeNode bstFromPreorder(int[] preorder) {
        head = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode next = new TreeNode(preorder[i]);
            processNode(head, next);
        }
        return head;
    }

    private void processNode(TreeNode root, TreeNode next) {
        if (next.val < root.val) {
            if (root.left != null) {
                processNode(root.left, next);
            } else {
                root.left = next;
            }
        } else {
            if (root.right != null) {
                processNode(root.right, next);
            } else {
                root.right = next;
            }
        }
    }
}


class TreeNode {
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
