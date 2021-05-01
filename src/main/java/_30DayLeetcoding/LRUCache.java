package main.java._30DayLeetcoding;

import java.util.HashMap;
import java.util.Map;

/****
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached
 * its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(capacity)
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // returns 1
 *cache.put(3,3);    // evicts key 2
 *cache.get(2);       // returns -1 (not found)
 *cache.put(4,4);    // evicts key 1
 *cache.get(1);       // returns -1 (not found)
 *cache.get(3);       // returns 3
 *cache.get(4);       // returns 4
 */
public class LRUCache {

    Map<Integer, Node> map;
    int maxCapacity;
    int totalItemsInCache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.totalItemsInCache = 0;
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            Node temp = new Node();
            temp.key = key;
            temp.val = val;
            addToFront(temp);
            totalItemsInCache++;
            map.put(key, temp);

            if (totalItemsInCache > maxCapacity) {
                removeLRUEntry();
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    private void removeLRUEntry() {
        Node lastNode = popTail();
        map.remove(lastNode.key);
        --totalItemsInCache;
    }

    private Node popTail() {
        Node tailItem = tail.prev;
        removeFromList(tailItem);
        return tailItem;
    }

    private void moveToHead(Node node) {
        removeFromList(node);
        addToFront(node);
    }

    private void removeFromList(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        lruCache.put(1, 3);
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(5));


    }

}

class Node {
    int key;
    int val = -1;
    Node prev;
    Node next;
}
