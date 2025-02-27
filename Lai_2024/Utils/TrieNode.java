package Utils;

import java.util.Map;

public class TrieNode {
    public int count; // after this node, how many nodes with isWord == true
    public Map<Character, TrieNode> children;
    public boolean isWord;
}
