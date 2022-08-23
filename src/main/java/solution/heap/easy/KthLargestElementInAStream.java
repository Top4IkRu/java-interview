package solution.heap.easy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">Task 703</a>
 */
public class KthLargestElementInAStream {

    class KthLargest {

        Queue<Integer> q;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.q = new PriorityQueue<>();

            for (int i : nums) q.add(i);

            while (q.size() > k) q.poll();
        }

        public int add(int val) {
            q.add(val);
            while (q.size() > k) q.poll();
            return q.peek();
        }
    }
}
