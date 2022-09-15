package solution.tree.easy;

import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/subtree-of-another-tree/">Task 572</a>
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode rootNode, TreeNode subRootNode) {
        if (rootNode == null && subRootNode == null) return true;
        if (rootNode == null || subRootNode == null) return false;

        if (rootNode.val != subRootNode.val) return false;

        return isSame(rootNode.left, subRootNode.left) && isSame(rootNode.right, subRootNode.right);
    }
}
