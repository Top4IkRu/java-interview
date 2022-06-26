package solution.tree.easy;

import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Task 543</a>
 */
public class DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return diameter;
    }

    private int calculate(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int l = root.left == null ? 0 : calculate(root.left) + 1;
        int r = root.right == null ? 0 : calculate(root.right) + 1;
        if (l + r > diameter) diameter = l + r;
        return Math.max(l, r);
    }
}
