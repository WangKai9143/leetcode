package trieTree;

public class Trie2 {
    private Trie2[] children;
    private boolean isWord;

    Trie2() {
        children = new Trie2[26];
        isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie2 node = this;
        for (Character itemCh : word.toCharArray()) {
            if (node.children[itemCh - 'a'] == null) {
                node.children[itemCh - 'a'] = new Trie2();
            }
            node = node.children[itemCh - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie2 node = startsPrefix(word);
        return node!=null && node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie2 node = startsPrefix(prefix);
        return node != null;
    }

    public Trie2 startsPrefix(String prefix) {
        Trie2 node = this;
        for (Character itemCh : prefix.toCharArray()) {
            if (node.children[itemCh - 'a'] == null) {
                return null;
            }
            node = node.children[itemCh - 'a'];
        }
        return node;
    }
}
