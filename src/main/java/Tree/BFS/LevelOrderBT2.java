package main.java.Tree.BFS;

import java.util.ArrayList;
import java.util.List;

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

public class LevelOrderBT2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = height(root);
        int i = 1;
        while (i <= height) {
            List<Integer> list = new ArrayList<>();
            levelOrder(root, list, i);
            result.add(0, list);
            //result.add(list);
            i++;
        }
        return result;
    }


    private void levelOrder(TreeNode root, List<Integer> list, int height) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            list.add(root.val);
            return;
        }
        levelOrder(root.left, list, height - 1);
        levelOrder(root.right, list, height - 1);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrderBT2 test = new LevelOrderBT2();
        List<List<Integer>> fi = test.levelOrderBottom(root);
        System.out.println(fi);
    }
}

