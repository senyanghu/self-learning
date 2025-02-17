package A_04_Tree;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q05_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 两个节点都为空，继续检查
            if (node1 == null && node2 == null) {
                continue;
            }
            // 一个为空另一个不为空，或值不相等
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            // 加入对应的子节点对
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }
}
