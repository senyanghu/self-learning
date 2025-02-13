package A_加强练习1;

import java.util.List;

class TreeNode {
    int val;
    List<TreeNode> children;
}

// LCA for two nodes in K-naryTree
// k-叉树 找两个nodes的LCA
public class Q13_LowestCommonAncestor4 {
    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }

        int counter = 0;
        TreeNode temp = null;

        for (TreeNode child : root.children) {
            TreeNode node = LCA(child, a, b);
            if (node != null) {
                counter++;
                if (counter == 2) {
                    return root;
                }
                temp = node;
            }
        }
        return temp;
    }
}
