package A_加强练习2;

import Utils.TreeNode;

/*
Case 1: if target > root, root.right = delete(root.right, target)

Case 2: if target < root, root.left = delete(root.left, target)

Case 3: if target == root
    Case 3.1: if root is a leaf, return null
	Case 3.2: if root has only one child, return this child
	Case 3.3: if root has two children
	        step 1: find the node with the largest value in the left subtree
	        step 2: copy val 过来
	        step 3: recurse again to delete the node from the left subtree (再继续递归删除val的那个node)
 */

/*
deleteNode 函数返回的是删除目标节点后的新的（子）树的根节点。这个根节点可能是：
* 原来的 root
* root 的某个子节点
* null（如果删除后树为空）


每次递归调用都会返回一个 TreeNode，这个返回值会被父节点用来更新它的左或右子节点
当删除节点时，返回值决定了父节点应该连接到哪个新的子节点
对于根节点的删除，返回值将成为整个树的新根节点
这种设计使得我们可以在不使用父节点引用的情况下，通过返回值来维护树的结构。
 */
public class Q06_RemoveTargetFromBST {
    public TreeNode delete(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val < target) { // target is on the right subtree
            root.right = delete(root.right, target);
        } else if (root.val > target) { // target is on the left subtree
            root.left = delete(root.left, target);
        } else { // target is exactly the root
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                TreeNode smallest = findSmallest(root.right);
                root.val = smallest.val;
                root.right = delete(root.right, smallest.val);
            }
        }

        return root;
    }

    private TreeNode findSmallest(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
