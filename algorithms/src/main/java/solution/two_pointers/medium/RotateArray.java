package solution.two_pointers.medium;

/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Task 189</a>
 */
public class RotateArray {

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    /**
     * With two pointer
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int l = 0, r = nums.length - 1;
        // in reverse order
        reverse(nums, l, r);

        // reverse first part from 0 to [k-1]
        l = 0;
        r = k - 1;
        reverse(nums, l, r);

        // reverse first part from k to the end
        l = k;
        r = nums.length - 1;
        reverse(nums, l, r);

        int a = 0;
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l += 1;
            r -= 1;
        }
    }

    public void rotate2(int[] nums, int k) {
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
