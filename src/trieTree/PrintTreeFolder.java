package trieTree;

import java.util.*;

public class PrintTreeFolder {
    private int size;
    private Node root;

    private PrintTreeFolder() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        PrintTreeFolder trieTree = new PrintTreeFolder();
        trieTree.insertNode("a/b");
        trieTree.insertNode("a/b/c");
        trieTree.insertNode("a/d/c");
        trieTree.printTrie();
    }

    // 添加
    void insertNode(String param) {
        String[] params = param.split("/");
        Node curNode = this.root;
        for (String itemStr : params) {
            if (curNode.next.get(itemStr) == null) {
                curNode.next.put(itemStr, new Node());
            }
            curNode = curNode.next.get(itemStr);
        }
        if (!curNode.isFolder) {
            curNode.isFolder = true;
            this.size++;
        }
    }

    // 遍历trie树
    void printTrie() {
        Node curNode = this.root;
        Set<String> result = new TreeSet<>();
        List<String> path = new ArrayList<>();
        for (Map.Entry<String, Node> nodeMap : curNode.next.entrySet()) {
            dfs(nodeMap.getValue(),result,path);
        }
        System.out.println(result);
    }

    void dfs(Node top,Set<String> result,List<String> path) {
        if (top.next.isEmpty()) {
            result.add(path.toString());
        }
        for (Map.Entry<String, Node> nodeMap : top.next.entrySet()) {
            dfs(nodeMap.getValue(),result,path);
        }
    }

    class Node {
        boolean isFolder;
        Map<String, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isFolder) {
            this.isFolder = isFolder;
            this.next = new TreeMap<>();
        }
    }

}
