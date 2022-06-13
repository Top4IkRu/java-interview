package solution.linkedlist.medium;

/**
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">Task 287</a>
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] < 0) return v;
            nums[v - 1] *= -1;
        }
        throw new RuntimeException("Wrong test case!");
    }
}
