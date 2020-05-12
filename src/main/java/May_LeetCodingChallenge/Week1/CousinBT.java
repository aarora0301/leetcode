package main.java.May_LeetCodingChallenge.Week1;

/***
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *  Input: root = [1,2,3,4], x = 4, y = 3
 *  Output: false
 */
public class CousinBT {

    int parentX, depthX, parentY, depthY;

    public boolean isCousins(TreeNode root, int x, int y) {
        inOrder(root, x, y, -1, 0);
        return (depthX == depthY) && (parentY != parentX);
    }

    public void inOrder(TreeNode root, int x, int y, int parent, int depth) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            parentX = parent;
            depthX = depth;
        }
        if (root.val == y) {
            parentY = parent;
            depthY = depth;
        }
        inOrder(root.left, x, y, root.val, depth + 1);
        inOrder(root.right, x, y, root.val, depth + 1);
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        CousinBT test = new CousinBT();
        System.out.println(test.isCousins(head, 4, 3));
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
