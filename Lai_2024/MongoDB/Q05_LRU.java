package MongoDB;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedNode {
    int key;
    int value;
    DoublyLinkedNode pre;
    DoublyLinkedNode next;

    public DoublyLinkedNode() {
    }
}

public class Q05_LRU {
    private void addToHead(DoublyLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DoublyLinkedNode node) {
        DoublyLinkedNode prev = node.pre;
        DoublyLinkedNode next = node.next;
        prev.next = next;
        next.pre = prev;
    }

    private void moveToHead(DoublyLinkedNode node) {
        this.removeNode(node);
        this.addToHead(node);
    }

    private DoublyLinkedNode popTail() {
        DoublyLinkedNode node = this.tail.pre;
        this.removeNode(node);
        return node;
    }

    private Map<Integer, DoublyLinkedNode> cache;
    private int capacity;
    private int count;
    private DoublyLinkedNode head, tail;

    public Q05_LRU(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        head = new DoublyLinkedNode();
        tail = new DoublyLinkedNode();
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        DoublyLinkedNode node = this.cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedNode node = this.cache.get(key);
        if (node == null) {
            node = new DoublyLinkedNode();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            this.addToHead(node);
            this.count++;
            if (count > this.capacity) {
                DoublyLinkedNode poppedNode = this.popTail();
                this.cache.remove(poppedNode.key);
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}
