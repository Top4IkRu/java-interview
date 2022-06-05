package solution.arrays.medium;

/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">Task 238</a>
 */
public class ProductOfArrayExceptSelf {
    /**
     * Space - O(n)
     * Time - O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] * nums[i - 1];
            }
        }
        int m = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= m;
            m *= nums[i];
        }

        return arr;
    }
}
