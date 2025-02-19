package A_加强练习3_Recursion3;

import Utils.TreeNode;

/*
1. what do you expect from your lchild / rchild?
    Max single path in my left subtree (ended at the left child node)
    Max single path in my right subtree (ended at the right child node)
2. What do you want to do in the current layer?
    check left and right, if they are < 0, then we do not need them (we just need 0)
    Update global_max = left + right + root.value if feasible
3. What do you want to report to your parent (same as Q1 and Q3)
    It is usually the return type pf the recursion function
 */
public class Q03_MaxPathSumFromAnyNodeToAny {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    public int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left, maxSum);
        int right = maxPathSumHelper(root.right, maxSum);

        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;

        maxSum[0] = Math.max(maxSum[0], left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
