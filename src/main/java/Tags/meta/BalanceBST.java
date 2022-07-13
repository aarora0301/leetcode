package Tags.meta;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right= new TreeNode(4);
        BalanceBST balanceBST = new BalanceBST();
        System.out.println(balanceBST.balanceBST(root));

    }


    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    private TreeNode InsertBST(List<Integer> list, int start, int end) {

        if (start <= end) {
            int mid =  start+ ((end - start )/ 2);
            TreeNode newRoot = new TreeNode(list.get(mid));
           newRoot.left = InsertBST(list, start, mid - 1);
           newRoot.right = InsertBST(list, mid + 1, end);
           return newRoot;
        }
        return null;

    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list);
        return InsertBST(list, 0, list.size() - 1);
    }


}


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
