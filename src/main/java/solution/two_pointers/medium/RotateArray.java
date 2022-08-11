package solution.two_pointers.medium;

/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Task 189</a>
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        if (k > nums.length) k = k % nums.length;

        for (int i = 0; i < (nums.length / k) - 1; i++) {
            for (int j = 0; j < k; j++) {
                int i1 = nums.length - 1 - j - i * k;
                int i2 = nums.length - 1 - j - k * (i + 1);
                nums[i1] = nums[i1] ^ nums[i2];
                nums[i2] = nums[i1] ^ nums[i2];
                nums[i1] = nums[i1] ^ nums[i2];
            }
        }

        if (nums.length % k != 0) {
            for (int i = 0; i < nums.length - k - 1; i++) {
                nums[i] = nums[i + 1] ^ nums[i];
                nums[i + 1] = nums[i + 1] ^ nums[i];
                nums[i] = nums[i + 1] ^ nums[i];
            }
        }
    }
}
