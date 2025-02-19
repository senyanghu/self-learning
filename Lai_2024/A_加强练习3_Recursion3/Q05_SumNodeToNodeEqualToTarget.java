package A_加强练习3_Recursion3;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Q2.2 Given a binary tree in which each node contains an integer number.
Determine if there exists a path from any node to any node (the two nodes can be the same node and they can only
be on the path from root to one of the leaf nodes), the sum of the numbers on the path is equal to
the given target number.
 */
public class Q05_SumNodeToNodeEqualToTarget {
    /*
    优点：

思路直观，容易理解

使用path记录当前路径上的所有节点
每到一个新节点，计算从该节点向上到每个祖先节点的路径和
实现简单

使用ArrayList存储路径
使用boolean数组传递结果
回溯操作清晰
缺点：

性能较差

时间复杂度：O(nh)，其中n是节点数，h是树高
对每个节点都要重新计算所有可能的路径和
重复计算多

每次都要从当前节点往上重新累加计算和
     */
    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        boolean[] isExist = {false};
        List<TreeNode> path = new ArrayList<>();
        existHelper(root, isExist, path, target);
        return isExist[0];
    }

    private void existHelper(TreeNode root, boolean[] isExist, List<TreeNode> path, int target) {
        if (root == null) {
            return;
        }

        path.add(root);

        int temp = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            temp += path.get(i).val;
            if (temp == target) {
                isExist[0] = true;
            }
        }

        existHelper(root.left, isExist, path, target);
        existHelper(root.right, isExist, path, target);

        path.remove(path.size() - 1);
    }

    public boolean existV2(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        boolean[] isExist = {false};
        Set<Integer> prefixSums = new HashSet<>();
        prefixSums.add(0);  // 添加0以处理从根节点开始的路径

        existHelperV2(root, isExist, target, 0, prefixSums);
        return isExist[0];
    }

    private void existHelperV2(TreeNode root, boolean[] isExist, int target,
                               int currentSum, Set<Integer> prefixSums) {
        if (root == null) {
            return;
        }

        // 更新当前路径和
        currentSum += root.val;

        // 检查是否存在符合条件的路径
        if (prefixSums.contains(currentSum - target)) {
            isExist[0] = true;
        }

        // 添加当前路径和到HashSet
        boolean added = prefixSums.add(currentSum);

        existHelperV2(root.left, isExist, target, currentSum, prefixSums);
        existHelperV2(root.right, isExist, target, currentSum, prefixSums);

        // 回溯：移除当前路径和
        if (added) {
            prefixSums.remove(currentSum);
        }
    }

}
