package main.java.Tree.DFS;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthOfBT {


    private int maxWidth = 0;


    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        dfs(root, 0, 0, hashMap);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int colIndex, Map<Integer, Integer> hashMap) {
        if (root == null) {
            return;
        }
        if (!hashMap.containsKey(depth)) {
            hashMap.put(depth, colIndex);
        }

        int firstIndex = hashMap.get(depth);
        maxWidth = Math.max(maxWidth, colIndex - firstIndex + 1);
        dfs(root.left, depth + 1, 2 * colIndex, hashMap);
        dfs(root.right, depth + 1, 2 * colIndex + 1, hashMap);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        MaxWidthOfBT bt = new MaxWidthOfBT();
        int result = bt.widthOfBinaryTree(root);
        System.out.println(result);
    }
}
