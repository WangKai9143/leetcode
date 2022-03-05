package trieTree;

import java.util.Map;
import java.util.TreeMap;

/**
 * 字典树的实现
 *
 */
public class Trie {
    // 记录单词数量
    private int size;
    //
    private Node root;

    private Trie() {
        root = new Node();
        size = 0;
    }

    public static void main(String[] args) {
        Trie trieTree = new Trie();
    }


    // 添加
    void insert(String word) {
        Node curNode = root;
        for (Character itemCh : word.toCharArray()) {
            if (curNode.next.get(itemCh) == null) {
                curNode.next.put(itemCh, new Node());
            }
            curNode = curNode.next.get(itemCh);
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
            this.size++;
        }
    }

    boolean search(String word) {
        Node curNode = root;
        for (Character itemCh : word.toCharArray()) {
            if (curNode.next.get(itemCh) == null) {
                return false;
            }
            curNode = curNode.next.get(itemCh);
        }
        return curNode.isWord;
    }

    boolean startsWith(String word) {
        Node curNode = root;
        for (Character itemCh : word.toCharArray()) {
            if (curNode.next.get(itemCh) == null) {
                return false;
            }
            curNode = curNode.next.get(itemCh);
        }
        return true;
    }
}

class Node {
    boolean isWord;
    Map<Character, Node> next;

    public Node() {
        this(false);
    }

    public Node(boolean isWord) {
        this.isWord = isWord;
        this.next = new TreeMap<>();
    }
}
