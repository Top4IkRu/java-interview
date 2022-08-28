package solution.heap.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Task 215</a>
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        return heap.peek();
    }
}
