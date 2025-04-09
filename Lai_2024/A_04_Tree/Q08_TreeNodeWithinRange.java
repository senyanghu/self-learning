package A_04_Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q08_TreeNodeWithinRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        getRangerHelper(root, min, max, res);
        return res;
    }

    private void getRangerHelper(TreeNode root, int min, int max, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val > min) { // 优化
            getRangerHelper(root.left, min, max, res);
        }
        if (root.val >= min && root.val <= max) {
            res.add(root.val);
        }
        if (root.val < max) { // 优化
            getRangerHelper(root.right, min, max, res);
        }
    }
}
