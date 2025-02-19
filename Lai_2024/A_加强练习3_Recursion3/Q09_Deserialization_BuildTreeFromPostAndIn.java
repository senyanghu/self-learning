package A_加强练习3_Recursion3;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q09_Deserialization_BuildTreeFromPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLength = inorder.length;
        int postLength = postorder.length;
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positionMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inLength - 1, postorder, 0, postLength - 1, positionMap);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
                              Map<Integer, Integer> positionMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = positionMap.get(root.val);

        int len = rootIndex - inStart; // left size

        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + len - 1, positionMap);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + len, postEnd - 1, positionMap);

        return root;
    }
}
