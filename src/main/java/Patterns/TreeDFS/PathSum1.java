package Patterns.TreeDFS;

public class PathSum1 {

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

    boolean result= Boolean.FALSE;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        inOrder(root, 0, targetSum);
        return result;

    }

    private void inOrder(TreeNode root, int currSum, int targetSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == targetSum) {
            result = Boolean.TRUE;
            return;
        }

        inOrder(root.left, currSum, targetSum);
        inOrder(root.right, currSum, targetSum);
    }

    public static void main(String[] args) {
        PathSum1 pathSum1 = new PathSum1();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        System.out.println(pathSum1.hasPathSum(treeNode, 5));
    }
}
