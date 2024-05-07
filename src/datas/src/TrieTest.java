package datas.src;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrieTest {
    private Trie trie;

    @BeforeEach
    public void setup() {
        trie = new Trie();
    }

    @Test
    public void testInsertAndSearch() {
        trie.insert("hello");
        assertTrue(trie.search("hello"));
        assertFalse(trie.search("helloo"));
  
    }

    @Test
    public void testDelete() {
        trie.insert("hello");
        trie.insert("helium");
        assertTrue(trie.search("hello"));
        trie.delete("hello");
        assertFalse(trie.search("hello"));
        assertTrue(trie.search("helium"));
        trie.delete("helium");
        assertFalse(trie.search("helium"));
    }
}
 
