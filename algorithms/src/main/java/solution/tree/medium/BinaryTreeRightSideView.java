package solution.tree.medium;

import solution.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Task 199</a>
 */
public class BinaryTreeRightSideView {

    /**
     * Основная идея:
     * сохранить размер текущей очереди (size), пройти через первые size элементов и сохранить всех детей в очередь.
     * При этом, при добавлении элементов в очередь, сначала добавляем правого ребенка.
     * Это позволяет гарантировать, что первым элементом во вложенном цикле будет самый правый элемент уровня.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) result.add(node.val);
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
        }
        return result;
    }
}
