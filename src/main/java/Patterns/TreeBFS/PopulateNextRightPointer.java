package Patterns.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

    static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }


        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node top = queue.poll();
                    if (i < size - 1) {
                        top.next = queue.peek();
                    }
                    if (top.left != null) {
                        queue.add(top.left);
                    }

                    if (top.right != null) {
                        queue.add(top.right);
                    }

                }
            }

            return root;
        }

    }

    public static void main(String[] args) {

    }

}
