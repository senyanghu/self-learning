package A_加强练习6_BinarySearch;

import Utils.DLinkedNode;

import java.util.HashMap;

/*
Implement the LRUCache class:

* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
 */
public class Q04_LRU {
    // add the new node right after head
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    // remove an existing node from the linked list
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    // move a node ahead
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public Q04_LRU(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise an exception here
        }
        // move the accessed node to the head
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;
            if (count > capacity) {
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}
