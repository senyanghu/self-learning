package A_加强练习1;


import Utils.KnaryTreeNode;

// LCA for two nodes in K-naryTree
// k-叉树 找两个nodes的LCA
public class Q13_LowestCommonAncestor4 {
    public KnaryTreeNode LCA(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }

        int counter = 0;
        KnaryTreeNode temp = null;

        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode node = LCA(child, a, b);
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
