package solution.tree.easy;

import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Task 100</a>
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
