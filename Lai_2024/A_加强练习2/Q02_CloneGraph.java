package A_加强练习2;

import Utils.UndirectedGraphNode;

import java.util.Map;

/*
(Graph) How to copy a graph with possible cycles? G-> G'
N1 -- N2     N1' --- N2'
\    /       \     /
  N3            N3'
Method: build a hash_map to avoid duplication when copying a node.
 */
public class Q02_CloneGraph {
    /*
Solution: BFS1
Step 1: Expanding N1: make a copy of N1   copy(N1, N1') and insert   <N1 --> N1'> into the hashtable

Generate N2: since N2 is not in hashtable yet,  new(N2'), insert <N2-->N2'> into the hash table.
Generate N3: since N3 is not in hashtable yet,  new(N3'), insert <N3-->N3'> into the hash table.

Step2: Expanding N2:
-- generate N3, since N3 is already in the hashtable, we do not need to new(N3'), we only need to find the 1:1 mapping between N3 and N3',  that is  N2'-> N3'
Step3: Expanding N3:
-- generate nothing since all its neighbor have been expanded.....
     */


    // DFS way of doing it
    // 精妙
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode input,
                                          Map<UndirectedGraphNode, UndirectedGraphNode> lookup) {
        if (input == null) {
            return input;
        }
        if (lookup.containsKey(input)) {
            return lookup.get(input);
        }

        UndirectedGraphNode copyNode = new UndirectedGraphNode(input.label);
        lookup.put(input, copyNode);
        for (UndirectedGraphNode neighbor : input.neighbors) {
            UndirectedGraphNode copyNeighbor = cloneGraph(neighbor, lookup);
            copyNode.neighbors.add(copyNeighbor);
        }

        return copyNode;
    }
}
