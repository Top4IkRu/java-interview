package solution.tree.medium;

import solution.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Task 102</a>
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Основаная идея:
     * запомнить размер текущего уровня дерева (levelSize) и последовательно обработать все узлы этого уровня.
     * После этого перейти к следующему уровню и повторить процесс до тех пор, пока очередь не станет пустой.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelSize = q.size();
        List<Integer> level = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            level.add(node.val);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);

            levelSize--;
            if (levelSize == 0) {
                list.add(level);
                level = new LinkedList<>();
                levelSize = q.size();
            }
        }
        return list;
    }
}
