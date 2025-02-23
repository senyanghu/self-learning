package A_05_Heap_Graph_1;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 对于完全二叉树的判断，我们可以使用BFS层序遍历，主要思路是：如果遇到了一个空节点后，后面不应该再有非空节点。

/*

经典例题3: Determine whether a binary tree is a complete binary tree

[Binary tree diagram showing:]
        1
       / \
      3   2  ← 2 is the first node that misses one child node
    / \  / \
   5  4  7 null
 / \  / \
9 11 null null

Case1: if we found a node that misses its left child (right child != null) return false;
Case2: after detecting the first node that misses one child, then check whether all following nodes expanded to
see whether they have any node generated (if any → then false)
 */
public class Q03_IsComplete {
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 本质上这条题目的核心就是 如果见到了不完整的节点以后 那么后来所有的节点都应该没有子嗣
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
