package main.java.Tree.DFS;

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
        TrieNode temp = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode temp = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return temp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        int index;
        for (int i = 0; i < prefix.length(); i++) {
            index = prefix.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return true;
    }

    public static void main(String[] args) {

    }

}

class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}