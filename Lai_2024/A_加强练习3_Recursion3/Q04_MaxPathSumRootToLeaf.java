package A_加强练习3_Recursion3;

import Utils.TreeNode;

// 相当于是 preorder 遍历的过程中计算一个最大值
public class Q04_MaxPathSumRootToLeaf {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = {Integer.MIN_VALUE};
        int prefix = 0;
        maxPathSumHelper(root, prefix, max);
        return max[0];
    }

    private void maxPathSumHelper(TreeNode root, int prefix, int[] max) {
        if (root == null) {
            return;
        }

        prefix += root.val;

        if (root.left == null && root.right == null) {
            max[0] = Math.max(max[0], prefix);
            return;
        }
        maxPathSumHelper(root.left, prefix, max);
        maxPathSumHelper(root.right, prefix, max);
    }
}
