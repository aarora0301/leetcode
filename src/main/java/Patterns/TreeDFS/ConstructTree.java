package Patterns.TreeDFS;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return arrayToTree(preorder, map, 0, 0, inorder.length - 1);

    }

    private TreeNode arrayToTree(int[] preOrder, Map<Integer, Integer> map, Integer preOrderIndex, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(val);
        root.left = arrayToTree(preOrder, map, preOrderIndex, start, map.get(val) - 1);
        root.right = arrayToTree(preOrder, map, preOrderIndex, map.get(val) + 1, end);
        return root;
    }

}
