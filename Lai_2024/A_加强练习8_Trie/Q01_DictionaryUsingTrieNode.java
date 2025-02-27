package A_加强练习8_Trie;

import Utils.TrieNode;

public class Q01_DictionaryUsingTrieNode {
    public boolean search(TrieNode root, String target) {
        // sanity check
        if (target == null || target.length() == 0) {
            return false;
        }

        TrieNode cur = root;
        // match the characters one by one
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            // try to match one child of cur node
            TrieNode next = cur.children.get(c);
            if (next == null) {
                return false;
            }
            cur = next;
        }

        return cur.isWord;
    }

    public void insert(TrieNode root, String target) {
        // sanity check
        if (target == null || target.length() == 0) {
            return;
        }

        TrieNode cur = root;
        // match the characters one by one
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            // try to match one child of cur node
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWord = true;
    }

    public boolean delete(TrieNode root, String target) {
        // sanity check
        if (!(search(root, target))) {
            return false;
        }

        TrieNode cur = root;
        // match the characters one by one
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            // try to match one child of cur node
            TrieNode next = cur.children.get(c);
            if (next.count == 1) {
                cur.children.remove(c);
                return true;
            }
            next.count--;
            cur = next;
        }
        cur.isWord = false;
        return true;
    }
}
