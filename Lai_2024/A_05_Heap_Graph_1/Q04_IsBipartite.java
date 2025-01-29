package A_05_Heap_Graph_1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;

    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}

public class Q04_IsBipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        for (GraphNode node : graph) {
            if (!visited.containsKey(node)) {
                queue.offer(node);
                visited.put(node, 0);
                while (!queue.isEmpty()) {
                    GraphNode currentNode = queue.poll();
                    int currentColor = visited.get(currentNode);
                    for (GraphNode neighbor : currentNode.neighbors) {
                        if (!visited.containsKey(neighbor)) {
                            queue.offer(neighbor);
                            visited.put(neighbor, 1 - currentColor);
                        } else if (!visited.get(neighbor).equals(currentColor)) { // neighbor is already been visited
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
