package A_加强练习8_Trie;

import Utils.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Given a trie tree, you are given a prefix like 'ca'

You are expected to get 'cap', 'cat', 'cathy'


The text in the image reads:

1. what does it store on each level? (What is the semantic for each level)
   - We need to know the base case when we can stop from exploring deeper.
2. How many different states should we try to put on this level? (Based on the semantic, what are all the options we can go for the next level)

e.g. match "??p"
- 3 levels, each level is trying to match one of the character in the target.
- what are the possible next level states?
   1. '?' -- all the children
   2. 'p' -- the corresponding children of 'p'

            ()
    /'a'    \'c'    \'d'    -- level 0 match '?'
    ()      ()      ()
 /'t' \'p'    \'a'    \'o'    -- level 1 match '?'
()    ()       ()      ()
 */
public class Q02_FindAllWithPrefix {
    public List<String> findAllWithPrefix(TrieNode root, String prefix) {
        // step 1
        TrieNode matchNode = search(root, prefix);
        List<String> result = new ArrayList<>();
        if (matchNode == null) {
            return result;
        }
        DFSHelper(result, matchNode, new StringBuilder(prefix));
        return result;
    }

    private void DFSHelper(List<String> result, TrieNode cur, StringBuilder curPath) {
        if (cur.isWord) {
            result.add(curPath.toString());
            // return;
        }
        // base case
        // induction rule
        for (Map.Entry<Character, TrieNode> child : cur.children.entrySet()) {
            curPath.append(child.getKey());
            DFSHelper(result, child.getValue(), curPath);
            curPath.deleteCharAt(curPath.length() - 1);
        }
    }


    public TrieNode search(TrieNode root, String target) {
        // sanity check
        if (target == null || target.length() == 0) {
            return null;
        }

        TrieNode cur = root;
        // match the characters one by one
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            // try to match one child of cur node
            TrieNode next = cur.children.get(c);
            if (next == null) {
                return null;
            }
            cur = next;
        }

        return cur;
    }
}
