package A_加强练习1;

import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import Utils.TreeNode;

/**
 * classical way to print the tree level by level in a zig-zag way
 * [Tree diagram shows levels:
 * Level 1: 1
 * Level 2: 2, 3
 * Level 3: 4, 5, 6, 7
 * Level 4: 8, 9]
 * deque = { }
 * Example
 * → 1
 * ← 3 2
 * → 4 5 6 7
 * ← 9 8
 * Solution: use a deque
 * Case 1: if we are on odd level: do the same as that in BFS1.
 * expand a node from the left end of the deque, generate left child and then
 * right child,
 * and insert them to the right end of the deque.
 * Case 2: if we are on even level: do the opposite as that in BFS1.
 * expand a node from the right end of the deque, generate right child and then
 * left child,
 * and insert them to the left end of the deque.
 */
public class Q10_BinaryTreeZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean leftToRight = true; // 标记遍历方向

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node;

                if (leftToRight) {
                    // 奇数层：从左到右
                    node = deque.pollFirst();
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    // 偶数层：从右到左
                    node = deque.pollLast();
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }

                level.add(node.val);
            }

            result.add(level);
            leftToRight = !leftToRight; // 切换方向
        }

        return result;
    }

    // 测试方法
    public static void main(String[] args) {
        Q10_BinaryTreeZigZag solution = new Q10_BinaryTreeZigZag();

        // 创建测试树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        System.out.println("ZigZag Level Order:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
