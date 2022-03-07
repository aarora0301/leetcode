import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {


    public static void main(String[] args) {

    }

    private int later(TreeNode treeNode) {
        treeNode = treeNode.right;
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode.data;
    }

    private int former(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;

    }

    TreeNode traverseTree(TreeNode root, int targetNode) {

        if (root == null) {
            return null;
        }
        if (targetNode > root.data) {
            root.right = traverseTree(root.right, targetNode);
        } else if (targetNode < root.data) {
            root.left = traverseTree(root.left, targetNode);

        } else {
            if (root.left == null && root.right == null) { // leaf node
                root = null;
            } else if (root.right != null) {
                root.data = later(root);
                root.right = traverseTree(root.right, root.data);
            } else {
                root.data = former(root);
                root.left = traverseTree(root.left, root.data);
            }

        }
        return root;

    }

}


class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;
}