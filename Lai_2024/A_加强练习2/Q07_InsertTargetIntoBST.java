package A_加强练习2;

import Utils.TreeNode;

public class Q07_InsertTargetIntoBST {
    public TreeNode insertIntoBSTRecursively(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        // 如果找到相同的key，直接返回（不做改变）
        if (root.val == val) {
            return root;
        }

        if (root.val > val) { // needs to insert into left subtree
            root.left = insertIntoBSTRecursively(root.left, val);
        } else if (root.val < val) { // needs to insert into right subtree
            root.right = insertIntoBSTRecursively(root.right, val);
        }

        // return the unchanged node pointer
        return root;
    }

    public TreeNode insertIntoBSTIteratively(TreeNode root, int val) {
        // 处理空树的情况
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;
        while (true) {
            // 如果找到相同的key，直接返回
            if (curr.val == val) {
                return root;
            }

            // 往左子树走
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            }
            // 往右子树走
            else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }
}
