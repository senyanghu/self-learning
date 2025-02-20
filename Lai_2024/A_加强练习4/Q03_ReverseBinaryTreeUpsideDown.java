package A_加强练习4;

import Utils.TreeNode;

public class Q03_ReverseBinaryTreeUpsideDown {
    public TreeNode reverseTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = reverseTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
