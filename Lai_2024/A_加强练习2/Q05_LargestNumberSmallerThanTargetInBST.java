package A_加强练习2;

import Utils.TreeNode;

// 在所有的比target小的node中 找个最大的 矮子里拔将军
public class Q05_LargestNumberSmallerThanTargetInBST {
    public int largestSmaller(TreeNode root, int target) {
        int res = Integer.MIN_VALUE;
        while (root != null) {
            if (root.val >= target) {
                root = root.left;
            } else { // root.val < target
                res = root.val;
                root = root.right;
            }
        }
        return res;
    }
}
