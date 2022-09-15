package solution.heap.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/k-closest-points-to-origin/description/">Task 973</a>
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
                Comparator.comparing(l -> Math.sqrt(Math.pow(l.get(0), 2) + Math.pow(l.get(1), 2)))
        );

        for (int[] coordinates : points) {
            List<Integer> list = new ArrayList<>();
            list.add(coordinates[0]);
            list.add(coordinates[1]);
            queue.add(list);
        }

        int[][] r = new int[k][2];
        for (int i = 0; i < k; i++) {
            List<Integer> l = queue.poll();
            r[i] = new int[2];
            r[i][0] = l.get(0);
            r[i][1] = l.get(1);
        }
        return r;
    }

}
