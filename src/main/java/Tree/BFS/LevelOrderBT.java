package main.java.Tree.BFS;


import java.util.ArrayList;
import java.util.List;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}


/***
 *   Level order via Recursion
 */
public class LevelOrderBT {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = height(root);
        int i = 1;
        while (i <= height) {
            List<Integer> levelList = new ArrayList<>();
            levelOrder(root, i, levelList);
            result.add(levelList);
            i++;
        }
        return result;
    }

    private void levelOrder(TreeNode root, int height, List<Integer> list) {
        if (root == null || height <= 0) {
            return;
        }
        if (height == 1) {
            list.add(root.val);
            return;
        }
        levelOrder(root.left, height - 1, list);
        levelOrder(root.right, height - 1, list);
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
        LevelOrderBT test = new LevelOrderBT();
        List<List<Integer>> fi = test.levelOrder(root);
        System.out.println(fi);
    }
}
