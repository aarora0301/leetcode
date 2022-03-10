package Patterns.TreeDFS;

public class SummRootToLeaf {


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

    Integer result = 0;

    public int sumNumbers(TreeNode root) {
        inOrder(root, new StringBuilder());
        return result;
    }

    private void inOrder(TreeNode root, StringBuilder currSum) {
        if (root == null) {
            return;
        }
        currSum.append(root.val);
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(currSum.toString());
        } else {
            inOrder(root.left, currSum);
            inOrder(root.right, currSum);
        }
        currSum.deleteCharAt(currSum.length() - 1);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(0);
        SummRootToLeaf test = new SummRootToLeaf();
        System.out.println(test.sumNumbers(treeNode));

    }

}
