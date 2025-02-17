package A_05_Heap_Graph_1;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 对于完全二叉树的判断，我们可以使用BFS层序遍历，主要思路是：如果遇到了一个空节点后，后面不应该再有非空节点。
public class Q03_IsComplete {
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean hasSeenNull = false;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // check the left child
            if (node.left != null) {
                if (hasSeenNull) {
                    return false;
                }
                queue.offer(node.left);
            } else {
                hasSeenNull = true;
            }

            // check the right child
            if (node.right != null) {
                if (hasSeenNull) {
                    return false;
                }
                queue.offer(node.right);
            } else {
                hasSeenNull = true;
            }
        }
        return true;
    }
}
