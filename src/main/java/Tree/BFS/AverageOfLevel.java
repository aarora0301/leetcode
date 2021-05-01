package main.java.Tree.BFS;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevel {


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int height = height(root);
        int i = 1;
        List<Integer> level = new ArrayList<>();
        while (i <= height) {
            preOrderTraversal(root, i, level);
            result.add(addList(level));
            level.clear();
            i++;
        }
        return result;
    }

    private double addList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum / list.size();
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private void preOrderTraversal(TreeNode root, int height, List<Integer> level) {
        if (root == null || height <= 0) {
            return;
        }
        if (height == 1) {
            level.add(root.val);
            return;
        }
        preOrderTraversal(root.left, height - 1, level);
        preOrderTraversal(root.right, height - 1, level);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        AverageOfLevel ls = new AverageOfLevel();
        List<Double> res = ls.averageOfLevels(root);
        System.out.println(res);
    }
}
