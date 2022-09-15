package solution.tree.easy;


import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">Task 110</a>
 */
public class BalancedBinaryTree {

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return result;
    }

    /**
     * A height-balanced binary tree is a binary tree in which the depth of the two subtrees
     * of every node never differs by more than one.
     */
    public int getDepth(TreeNode node) {
        if (node == null) return 0;

        int l = getDepth(node.left);
        int r = getDepth(node.right);
        if (Math.abs(l - r) > 1) result = false;
        return Math.max(l, r) + 1;
    }
}
