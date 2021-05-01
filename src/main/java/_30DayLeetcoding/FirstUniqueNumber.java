package main.java._30DayLeetcoding;

import java.util.HashSet;
import java.util.Set;

/****
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if
 * there is no such integer.
 * void add(int value) insert value to the queue.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add",
 * "showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 */
public class FirstUniqueNumber {

    Set<Integer> set;
    Node tail;
    Node head;

    public FirstUniqueNumber(int[] nums) {
        set = new HashSet<>();
        tail = new Node();
        head = new Node();
        head.next = tail;
        tail.prev = head;
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return tail.prev.val;
    }

    public void add(int value) {
        if (!set.contains(value)) {
            set.add(value);
            Node temp = new Node();
            temp.val = value;
            addToHead(temp);

        } else {
            removeNode(value);
        }

    }

    private void addToHead(Node node) {
        node.prev = head;
        Node temp = head.next;
        temp.prev = node;
        node.next = temp;
        head.next = node;
    }

    private void removeNode(int val) {
        Node temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                Node prev = temp.prev;
                Node next = temp.next;
                prev.next = next;
                next.prev = prev;
                break;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        FirstUniqueNumber firstUnique = new FirstUniqueNumber(new int[]{2, 2});
//        firstUnique.add(3);
//        firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
    }


}
