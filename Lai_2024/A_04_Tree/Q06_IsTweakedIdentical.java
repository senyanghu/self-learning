package A_04_Tree;

public class Q06_IsTweakedIdentical {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // base case: both nodes are null
        if (one == null && two == null) {
            return true;
        }
        if (one == null || two == null) {
            return false;
        }
        if (one.val != two.val) {
            return false;
        }

        return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) || (isTweakedIdentical(one.left, one.right) && isTweakedIdentical(one.right, two.left));
    }
}

/**
 * Tree1:       Tree2:
 *    1           1
 *   / \         / \
 *  2   3       2   3
 * / \  / \    / \ / \
 * 4 5  6 7    4 5 6 7
 *
 *
 *
 *
 * 递归过程：
 *
 * 先比较根节点1
 * 对于节点1的子节点，有两种可能：
 * 不交换：比较(2,2)和(3,3)
 * 交换：比较(2,3)和(3,2)
 * 每种可能都要继续递归比较它们的子节点
 * 所以那个图实际表达的是：
 *
 * 比较(1)：比较两棵树的根节点
 * 比较(2,3)：尝试一种组合方式
 * 比较(3,2)：尝试另一种组合方式（交换后）
 */