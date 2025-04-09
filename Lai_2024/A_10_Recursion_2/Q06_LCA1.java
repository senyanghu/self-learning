package A_10_Recursion_2;

import Utils.TreeNode;

public class Q06_LCA1 {
    public TreeNode LCA(TreeNode root,
                        TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root.val == one.val || root.val == two.val) {
            return root;
        }

        TreeNode left = LCA(root.left, one, two);
        TreeNode right = LCA(root.right, one, two);

        // case 1: If both sides are null
        // case 2: one side returns not NULL, and the other is NULL, return non-Null side
        // case 3: If both sides are not null, return current node
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else { // left != null && right != null
            return root;
        }
    }
}
