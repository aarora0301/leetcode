package main.java.May_LeetCodingChallenge.Week2;

/****
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            /**
             * Move to next link
             */
            node = node.children[index];
        }
        node.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        /***
         *  isEnd is evaluated because there can be two keys of type
         *  leet, leetcode where one key is prefix of other
         *  so we evaluate if we reached the end of string , we reached leaf node in a
         *  trie as well
         */
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int index;
        for (int i = 0; i < prefix.length(); i++) {
            index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abbcd");
        System.out.println(trie.search("abbcd"));
        System.out.println(trie.search("abb"));
        System.out.println(trie.startsWith("abb"));
        trie.insert("abb");
        System.out.println(trie.search("abb"));

    }
}

class TrieNode {
    Boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}