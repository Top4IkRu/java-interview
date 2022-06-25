package solution.tree.easy;

import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Task 104</a>
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
