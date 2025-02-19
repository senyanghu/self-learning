package A_加强练习3_Recursion3;

import Utils.TreeNode;

/*
 Given a binary tree in which each node contains an integer number. Find the
 maximum possible subpath sum(both the starting and ending node of the subpath
 should be on the same path from root to one of the leaf nodes, and the
 subpath is allowed to contain only one node).

 这条path 是 any node to any node
 但是必须是在同一条 直上直下的path上面
 */
public class Q06_MaxSubPath {

    // 这种解法相当于是 在tree的基础上跑 LargestSumSubarray
    // DP 的思想 + preorder traversal
    public int maxSubPath(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] max = {Integer.MIN_VALUE};
        helper(root, max, 0);
        return max[0];
    }

    public void helper(TreeNode root, int[] max, int sum) {
        if (root == null) {
            return;
        }

        if (sum < root.val) {
            sum = root.val;
        } else {
            sum = sum + root.val;
        }
        max[0] = Math.max(max[0], sum); // this is actually a preorder traversal

        helper(root.left, max, sum);
        helper(root.right, max, sum);
    }


    public int maxSubPathV2(TreeNode root) {
        // Write your solution here.
        int[] max = new int[]{Integer.MIN_VALUE};
        helperV2(root, max);
        return max[0];
    }

    private int helperV2(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        // step 1: get a max value from left subtree including root.left
        int left = helperV2(root.left, max);
        int right = helperV2(root.right, max);

        // step 2: 当前层要做的事情 比拼大小
        // 有托举就继承 没有托举就只靠自己
        int temp = Math.max(Math.max(left, right), 0);
        max[0] = Math.max(max[0], temp + root.val);

        // step 3: Finish the recursion
        return temp + root.val;
    }
}
