package A_加强练习3_Recursion3;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
How to reconstruct a tree (with no duplicate values) with pre-order and in-order sequences of all nodes
 */
public class Q08_Deserialization_BuildTreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;

        Map<Integer, Integer> positionHash = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            positionHash.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLength - 1, inorder, 0, inLength - 1, positionHash);
    }

    public TreeNode buildTree(int[] preorder,
                              int preStart,
                              int preEnd,
                              int[] inorder,
                              int inStart,
                              int inEnd,
                              Map<Integer, Integer> positionHash) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = positionHash.get(preorder[preStart]);

        int leftSubtreeSize = rootIndex - inStart;
        root.left = buildTree(preorder,
                preStart + 1,
                preStart + leftSubtreeSize,
                inorder,
                inStart,
                rootIndex - 1,
                positionHash
        );

        root.right = buildTree(
                preorder,
                preStart + leftSubtreeSize + 1,
                preEnd,
                inorder,
                rootIndex + 1,
                inEnd,
                positionHash
        );

        return root;
    }
}
