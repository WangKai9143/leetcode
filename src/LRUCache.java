import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<V> {


    private int capticity = 3;

    private ConcurrentHashMap<String, ListNode<String, V>> cacheHashMap = new ConcurrentHashMap();

    ListNode<String, V> head = null;
    ListNode<String, V> tail = null;

    public LRUCache(int capticity) {
        this.capticity = capticity;
        ListNode<String, V> head = new ListNode<>();
        ListNode<String, V> tail = new ListNode<>();
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
    }

    public V get(String key){
        ListNode<String,V> node = cacheHashMap.get(key);
        if (node == null){
            return null;
        }
        // 删除链表中的node
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // node放在头结点
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next= node;

        // 记录到hash中
        cacheHashMap.put(key,node);
        return node.value;
    }


    public void put(String key,V val){
        ListNode<String,V> node = cacheHashMap.get(key);
        if (node == null){
            if (cacheHashMap.size()==capticity){
                //移除最后一个节点
                ListNode<String,V> lastNode = tail.prev;
                lastNode.prev.next = tail;
                tail.prev = lastNode.prev;
                lastNode.prev = null;
                lastNode.next = null;
            }
            // 创建新节点
            node = new ListNode<>(key,val);
        }
        // 放在头结点
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next= node;
        cacheHashMap.put(key,node);
    }

    /**
     * 双向链表内部类
     */
    public static class ListNode<K, V> {
        private K key;
        private V value;
        ListNode<K, V> prev;
        ListNode<K, V> next;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public ListNode() {

        }
    }

    public static void main(String[] args) throws InterruptedException {
//        LRUCache<ListNode> cache = new LRUCache<>(4);
//        ListNode<String, Integer> node1 = new ListNode<>("key1", 1);
//        ListNode<String, Integer> node2 = new ListNode<>("key2", 2);
//        ListNode<String, Integer> node3 = new ListNode<>("key3", 3);
//        ListNode<String, Integer> node4 = new ListNode<>("key4", 4);
//        ListNode<String, Integer> node5 = new ListNode<>("key5", 5);
//        cache.put("key1", node1);
//        cache.put("key2", node2);
//        cache.put("key3", node3);
//        cache.put("key4", node4);
//        cache.get("key2");
//        cache.put("key5", node5);
//        cache.get("key2");
        Thread.sleep(10000L);
    }
}
