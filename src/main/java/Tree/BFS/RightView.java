package main.java.Tree.BFS;

import java.util.ArrayList;
import java.util.List;


public class RightView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }
        helper(root, 0, rightView);
        return rightView;
    }

    private void helper(TreeNode node, int level, List<Integer> rightView) {
        if (level == rightView.size()) {
            rightView.add(node.val);
        }
        if (node.right != null) {
            helper(node.right, level + 1, rightView);
        }
        if (node.left != null) {
            helper(node.left, level + 1, rightView);
        }
    }

    public static void main(String[] args) {

    }
}
