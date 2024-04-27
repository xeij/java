package datas.Trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26]; 
    boolean isEndOfWord; 

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode current = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode current = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return (current != null && current.isEndOfWord);
    }

    public void delete(String key) {
        delete(root, key, 0);
    }

    private boolean delete(TrieNode current, String key, int depth) {
        if (current == null) {
            return false;
        }

        if (depth == key.length()) {
            if (current.isEndOfWord) {
                current.isEndOfWord = false;
                return isEmpty(current);
            }
            return false;
        }

        int index = key.charAt(depth) - 'a';
        boolean shouldDeleteCurrentNode = delete(current.children[index], key, depth + 1);

        if (shouldDeleteCurrentNode) {
            current.children[index] = null;

            return !current.isEndOfWord && isEmpty(current);
        }

        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hello");
        trie.insert("helium");

        System.out.println("Search for 'hello': " + trie.search("hello"));
        System.out.println("Search for 'helium': " + trie.search("helium"));

        trie.delete("hello");
        System.out.println("Search for 'hello' after deleting: " + trie.search("hello")); 
        System.out.println("Search for 'helium' after deleting 'hello': " + trie.search("helium")); 
    }
}
