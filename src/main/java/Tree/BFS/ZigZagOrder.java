package main.java.Tree.BFS;

import java.util.ArrayList;
import java.util.List;

public class ZigZagOrder {


    public static void main(String[] args) {
        ZigZagOrder test = new ZigZagOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> fi = test.zigzagLevelOrder(root);
        System.out.println(fi);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = height(root);
        int i = 1;
        boolean flag = true;
        while (i <= height) {
            List<Integer> level = new ArrayList<>();
            zigzagLevelOrder(root, flag, level, i);
            flag = !flag;
            result.add(level);
            i++;
        }
        return result;
    }

    private void zigzagLevelOrder(TreeNode root, boolean flag, List<Integer> list, int height) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            if (flag) {
                list.add(root.val);
            } else {
                list.add(0, root.val);
            }
            return;
        }
        zigzagLevelOrder(root.left, flag, list, height - 1);
        zigzagLevelOrder(root.right, flag, list, height - 1);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
