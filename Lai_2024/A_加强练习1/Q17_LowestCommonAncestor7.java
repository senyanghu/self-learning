package A_加强练习1;

import A_04_Tree.TreeNode;

// LCA in a BST
// 想想BST的性质
public class Q17_LowestCommonAncestor7 {
    public TreeNode solution(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null)
            return root;

        if (root.val < one.val && root.val < two.val) {
            return solution(root.right, one, two);
        } else if (root.val > one.val && root.val > two.val) {
            return solution(root.left, one, two);
        } else {
            return root;
        }
    }
}
