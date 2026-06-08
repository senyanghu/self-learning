package A_加强练习6_BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Generic LRU Cache with O(1) get/put by count-based capacity.
 * - HashMap<K, Node<K,V>> for O(1) lookup
 * - Doubly-linked list to maintain recency (head = most recent, tail = least recent)
 */
public class Q05_LRU_Pro<K, V> {
    private static final class DLinkedNode<K, V> {
        K key;
        V value;
        DLinkedNode<K, V> pre;
        DLinkedNode<K, V> post;
        DLinkedNode() {}
        DLinkedNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<K, DLinkedNode<K, V>> cache = new HashMap<>();
    private final int capacity;
    private int count;
    private final DLinkedNode<K, V> head; // sentinel head
    private final DLinkedNode<K, V> tail; // sentinel tail

    public Q05_LRU_Pro(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.capacity = capacity;
        this.count = 0;
        this.head = new DLinkedNode<>();
        this.tail = new DLinkedNode<>();
        head.post = tail;
        tail.pre = head;
    }

    public V get(K key) {
        DLinkedNode<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        this.moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        DLinkedNode<K, V> node = cache.get(key);
        if (node != null) {
            node.value = value;
            this.moveToHead(node);
            return;
        }
        DLinkedNode<K, V> newNode = new DLinkedNode<>(key, value);
        this.cache.put(key, newNode);
        this.addNode(newNode);
        count++;
        if (count > capacity) {
            DLinkedNode<K, V> lru = this.popTail();
            this.cache.remove(lru.key);
            count--;
        }
    }

    public V remove(K key) {
        DLinkedNode<K, V> node = cache.remove(key);
        if (node == null) {
            return null;
        }
        this.removeNode(node);
        count--;
        return node.value;
    }

    // add the new node right after head
    private void addNode(DLinkedNode<K, V> node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    // remove an existing node from the linked list
    private void removeNode(DLinkedNode<K, V> node) {
        DLinkedNode<K, V> pre = node.pre;
        DLinkedNode<K, V> post = node.post;
        pre.post = post;
        post.pre = pre;
        node.pre = null;
        node.post = null;
    }

    // move a node ahead
    private void moveToHead(DLinkedNode<K, V> node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail
    private DLinkedNode<K, V> popTail() {
        DLinkedNode<K, V> res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        // Test Case 1: Integer -> String
        Q05_LRU_Pro<Integer, String> cache1 = new Q05_LRU_Pro<>(2);
        cache1.put(1, "one");
        cache1.put(2, "two");
        System.out.println(cache1.get(1)); // expect: one
        cache1.put(3, "three");     // evict key 2
        System.out.println(cache1.get(2)); // expect: null
        System.out.println(cache1.get(3)); // expect: three

        // Test Case 2: String -> Double
        Q05_LRU_Pro<String, Double> cache2 = new Q05_LRU_Pro<>(2);
        cache2.put("pi", 3.14);
        cache2.put("e", 2.71);
        System.out.println(cache2.get("pi"));  // expect: 3.14 (also refreshes recency)
        cache2.put("phi", 1.618);        // evict key "e"
        System.out.println(cache2.get("e"));   // expect: null
        System.out.println(cache2.get("phi")); // expect: 1.618
    }
}


