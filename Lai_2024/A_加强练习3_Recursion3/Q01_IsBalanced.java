package A_加强练习3_Recursion3;

import Utils.TreeNode;

public class Q01_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        int res = getHeight(root);
        if (res >= 0) {
            return true; // this tree is balanced
        } else {
            return false; // this tree is not balanced
        }
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // 三种不balanced的情况
        // 用特殊值 -1 代表不balance的情况
        // step 2
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
