package Patterns.TreeDFS;

public class DeleteNode {

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

    private int getSuccessor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;

    }

    private int getPredecessor(TreeNode treeNode) {
        treeNode = treeNode.left;
        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            return deleteNode(root.left, key);
        } else if (key > root.val) {
            return deleteNode(root.right, key);
        } else {

            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = getSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = getPredecessor(root);
                root.left = deleteNode(root.left, root.val);
            }

        }
        return root;

    }

}
