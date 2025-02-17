package A_04_Tree;

import Utils.TreeNode;

/**
 * 第1层（根节点）：需要遍历整棵树 = n 次操作
 * 第2层：每个节点需要遍历其子树 ≈ n/2 次操作
 * 第3层：每个节点需要遍历其子树 ≈ n/4 次操作
 * 第一层1个节点 第二层2个 第三层4个
 * 那么每一层就是n次操作
 * 总的时间复杂度就是 n*k (k = 层数)
 */
public class Q04_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 检查当前节点的平衡性
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
