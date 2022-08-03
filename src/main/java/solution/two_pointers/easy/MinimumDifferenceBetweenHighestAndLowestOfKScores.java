package solution.two_pointers.easy;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/">Task 1984</a>
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums); // O(n * log(n))

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int diff = Math.abs(nums[i] - nums[i + k - 1]);
            min = Math.min(diff, min);
        }

        return min;
    }
}
