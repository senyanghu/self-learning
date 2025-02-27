package A_加强练习8_Trie;

import Utils.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/*
           ()
    /'a'    \'c'    \'d'    -- level 0 match '?'
    ()      ()      ()
 /'t' \'p'    \'a'    \'o'    -- level 1 match '?'
()     ()      ()      ()
      /'p'   /'p' \'t'   \'p'    -- level 2 match 'p'
     ()     ()     ()     ()
 */
public class Q03_FindAllMatchWildCard {
    public List<String> findAllMatchWildCard(TrieNode root, String target) {
        List<String> result = new ArrayList<>();
        if (target == null || target.length() == 0) {
            return result;
        }

        StringBuilder curPath = new StringBuilder();
        findAllMatchByDFS(root, target, 0, curPath, result);
        return result;
    }

    // try to match the char at index to any of the children of cur node
    private void findAllMatchByDFS(TrieNode cur,
                                   String target,
                                   int index,
                                   StringBuilder curPath,
                                   List<String> result) {
        // this is base case
        if (index == target.length()) {
            // be careful about
            // 1. what is base case
            // 2. when to add the curPath into the result list
            if (cur.isWord) {
                result.add(curPath.toString());
            }
            return;
        }

        // recursive rule
        char toMatch = target.charAt(index);
        // case 1
        if (toMatch == '?') {
            for (Entry<Character, TrieNode> child : cur.children.entrySet()) {
                curPath.append(child.getKey());
                findAllMatchByDFS(child.getValue(), target, index + 1, curPath, result);
                curPath.deleteCharAt(curPath.length() - 1);
            }
        } else { // case 2
            TrieNode nextLevel = cur.children.get(toMatch);
            if (nextLevel != null) {
                curPath.append(toMatch);
                findAllMatchByDFS(nextLevel, target, index + 1, curPath, result);
                curPath.deleteCharAt(curPath.length() - 1);
            }
        }
    }
}
