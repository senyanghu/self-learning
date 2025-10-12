package A_04_Tree;

import Utils.TreeNode;

/*时间复杂度：O(n)
** 每个节点只访问一次
** 每个节点的操作是 O(1)
** 总时间：n × O(1) = O(n)

空间复杂度：O(h)
** h 是树的高度
** 递归栈的深度 */
public class Q07_IsBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
