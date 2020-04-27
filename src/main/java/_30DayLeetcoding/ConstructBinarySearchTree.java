package main.java._30DayLeetcoding;

/***
 *Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a
 * value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder
 * traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 */
public class ConstructBinarySearchTree {

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode head;

    public TreeNode bstFromPreorder(int[] preorder) {
        head = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode treeNode = new TreeNode(preorder[i]);
            processRootNode(head, treeNode);
        }
        return head;
    }


    private void processRootNode(TreeNode treeNode, TreeNode target) {
        if (target.val < treeNode.val) {
            if (treeNode.left != null) {
                processRootNode(treeNode.left, target);
            } else
                treeNode.left = target;

        } else {
            if (treeNode.right != null) {
                processRootNode(treeNode.right, target);
            } else {
                treeNode.right = target;
            }
        }
    }

    public static void main(String[] args) {
        ConstructBinarySearchTree test = new ConstructBinarySearchTree();
        test.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }
}
