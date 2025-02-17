package A_加强练习2;

import Utils.TreeNode;

/*
Q3.1: (Find a node whose value is closest to the target value)
Given a BST, how to find the node with its value closest to a target value x?

10 = current
  5       15        target == 13
2   7   12    20

Solution:
Maintain a closest node.
Start from the root node as cur.
Case 1: If (cur.value == target) just return cur
Case 2: If (cur.value < target) calculate the diff, if the |diff| is smaller than the closest node, update it.
        Goto right
Case 3: If (cur.value > target) calculate the diff, if the |diff| is smaller than the closest node, update it.
        Goto left
 */
public class Q04_ClosestNumberInBST {
    public int closestValue(TreeNode root, int target) {
        if (root == null) {
            return -1;
        }
        int res = root.val;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = target > root.val ? root.right : root.left;
        }

        return res;
    }
}
