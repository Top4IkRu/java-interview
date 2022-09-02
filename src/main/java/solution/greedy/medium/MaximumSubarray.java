package solution.greedy.medium;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Task 53</a>
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Обновление текущей суммы
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            // Обновление максимальной суммы
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
