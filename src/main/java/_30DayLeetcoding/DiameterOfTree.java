package main.java._30DayLeetcoding;
/****
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfTree {

    /***
     * Time : O(n^2)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight + rightHeight,
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


    private int height(TreeNode root, A a) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left, a);
        int rightHeight = height(root.right, a);
        a.ans = Math.max(a.ans, 1 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Time : O(n)
     */
    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        A a = new A();
        height(root, a);
        return a.ans;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

class A {
    int ans;

    A() {
        ans = Integer.MIN_VALUE;
    }

}

