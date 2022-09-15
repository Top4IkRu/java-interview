package solution.heap.easy;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/last-stone-weight/">Task 1046</a>
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(s -> s)));

        for (int i : stones) q.add(i);

        while (q.size() >= 2) {
            int y = q.poll();
            int x = q.poll();
            if (x != y) q.add(y - x);
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}
