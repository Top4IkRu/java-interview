package solution.tree.medium;

import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Task 235</a>
 * <p>
 * TODO Check again later
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor">LCA Wiki</a>
     * <p>
     * The lowest common ancestor is defined between two nodes p and q as the lowest node in T
     * that has both p and q as descendants (where we allow a node to be a descendant of itself).
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
