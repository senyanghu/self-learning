package A_加强练习1;

import java.util.Set;

// k叉树里面寻找k个node的LCA
// 本质就是如果找到counter == 2 的情况下 就直接返回root
public class Q14_LowestCommonAncestor5 {
    public KnaryTreeNode LCA(KnaryTreeNode root, Set<KnaryTreeNode> nodes) {
        if (root == null) {
            return root;
        }
        if (nodes.contains(root)) {
            return root;
        }

        int counter = 0;
        KnaryTreeNode temp = null;

        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode node = LCA(child, nodes);
            if (node != null) {
                counter++;
                if (counter >= 2) {
                    return root;
                }
                temp = node;
            }
        }

        return temp;
    }
}
