package Utils;

import java.util.Map;

public class TrieNode {
    // Before: after this node, how many nodes with isWord == true
    // After: 把 count 定义为“有多少单词路径经过该节点（包含在该节点结束的单词)
    public int count; 
    public Map<Character, TrieNode> children;
    public boolean isWord;
}
