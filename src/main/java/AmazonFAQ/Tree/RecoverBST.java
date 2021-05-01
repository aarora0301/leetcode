package main.java.AmazonFAQ.Tree;

public class RecoverBST {


    TreeNode first;
    TreeNode last;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int dummy = first.val;
        first.val = last.val;
        last.val = dummy;
    }

    public static void main(String[] args) {
        RecoverBST recover = new RecoverBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recover.recoverTree(root);
        System.out.println(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
