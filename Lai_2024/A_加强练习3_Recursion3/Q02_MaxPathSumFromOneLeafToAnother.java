package A_加强练习3_Recursion3;

import Utils.TreeNode;

/*
Q1.3 Midterm 2 question 2 (重复强调，简要复习)
Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
The maximum sum path may or may not go through root. For example, in the following binary tree,
the maximum sum is 27(3 + 6 + 9 + 0 - 1 + 10). Expected time complexity is O(n).

          -15
       /        \
      5          6
    /   \      /   \
   8     1    3     9
  / \               \
 2   6              0
                   /  \
                  4    -1
                        \
                        10

The red curved line in the image indicates the path that gives the maximum sum of 27,
which goes through: 3 -> 6 -> 9 -> 0 -> -1 -> 10
This corresponds to the example mentioned in the previous question where the maximum sum path of 27
is calculated as: 3 + 6 + 9 + 0 + (-1) + 10 = 27

1. what do you expect from your lchild / rchild?
    Max single path in my left subtree (ended at the left child node)
    Max single path in my right subtree (ended at the right child node)
2. What do you want to do in the current layer?
    Update global_max = left + right + root.value if feasible (两边不为空)
3. What do you want to report to your parent (same as Q1 and Q3)
    It is usually the return type pf the recursion function
 */
public class Q02_MaxPathSumFromOneLeafToAnother {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        if (root.left != null && root.right != null) {
            maxSum = Math.max(maxSum, left + root.val + right);
        }

        if (root.left == null) {
            return root.val + right;
        } else if (root.right == null) {
            return root.val + left;
        } else {
            return Math.max(left, right) + root.val;
        }
    }
}
