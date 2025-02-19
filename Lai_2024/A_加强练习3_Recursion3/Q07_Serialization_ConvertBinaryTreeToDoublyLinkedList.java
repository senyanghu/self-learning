package A_加强练习3_Recursion3;

import Utils.TreeNode;

/*
Given a Binary Tree, convert it to a Doubly Linked List(DLL) in in-order sequence.

            10 =cur
            /    \
          5      15
        /  \    /  \
head=   2   7  12   20
 */
public class Q07_Serialization_ConvertBinaryTreeToDoublyLinkedList {
    private TreeNode prev = null;  // 记录前一个处理的节点

    public TreeNode toDoubleLinkedList(TreeNode root) {
        if (root == null) return null;

        // 找到最左节点作为头节点
        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }

        inorderConvert(root);
        return head;
    }

    private void inorderConvert(TreeNode curr) {
        if (curr == null) return;

        // 1. 先处理左子树
        inorderConvert(curr.left);

        // 2. 处理当前节点
        if (prev != null) {
            // 建立双向连接
            prev.right = curr;   // 前一个节点的right指向当前节点
            curr.left = prev;    // 当前节点的left指向前一个节点
        }
        prev = curr;  // 更新prev为当前节点

        // 3. 处理右子树
        inorderConvert(curr.right);
    }
}
