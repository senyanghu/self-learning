package A_04_Tree;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q01_InOrder_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 把所有左节点压入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 处理栈顶元素
            curr = stack.pop();
            result.add(curr.val);

            // 转向右子树
            curr = curr.right;
        }

        return result;
    }

}
