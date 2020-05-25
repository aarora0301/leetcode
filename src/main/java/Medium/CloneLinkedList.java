package main.java.Medium;

import java.util.HashMap;
import java.util.Map;

/****
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val,
 * random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point
 * to any node.
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CloneLinkedList {
    /*****
     * Clone linked list using HashMap
     * space cpmplexity--> O(n)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node clonedHead = null;
        Node temp = null;
        Map<Node, Node> map = new HashMap<>();
        Node tempHead = head;
        /**
         *  a. create deep copy  with next pointer from original linked list
         *  b. create a mapping between original node and cloned node
         */
        while (tempHead != null) {
            if (clonedHead == null) {
                clonedHead = new Node(tempHead.val);
                temp = clonedHead;
                map.put(tempHead, temp);
            } else {
                temp.next = new Node(tempHead.val);
                map.put(tempHead, temp.next);
                temp = temp.next;
            }
            tempHead = tempHead.next;
        }

        temp = clonedHead;
        tempHead = head;
        /***
         * Build random link in cloned list
         */
        while (tempHead != null) {
            Node clonedNode = map.get(tempHead.random);
            temp.random = clonedNode;
            tempHead = tempHead.next;
            temp = temp.next;
        }
        return clonedHead;
    }

    public static void main(String[] args) {
        CloneLinkedList test = new CloneLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        test.copyRandomList(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
