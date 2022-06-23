package solution.tree.easy;

import solution.tree.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Task 226</a>
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invertTreeNode(root);
        return root;
    }

    private void invertTreeNode(TreeNode node) {
        if (node == null) return;

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invertTreeNode(node.left);
        invertTreeNode(node.right);
    }
}
