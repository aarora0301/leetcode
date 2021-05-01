package main.java.Tree.BFS;

public class RightPointer2 {


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        link(root);
        return root;
    }

    private void link(Node root) {
        if (root == null) {
            return;
        }
        Node next = root.next;

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(next);
            }
        }
        if (root.right != null) {
            root.right.next = findNext(next);
        }

        link(root.right);
        link(root.left);

    }


    private Node findNext(Node next) {
        if (next == null) {
            return null;
        }
        Node curr = next;
        while (curr != null) {
            if (curr.left != null) {
                return curr.left;
            }
            if (curr.right != null) {
                return curr.right;
            }
            curr = curr.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
