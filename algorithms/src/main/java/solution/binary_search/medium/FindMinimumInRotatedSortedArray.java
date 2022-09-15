package solution.binary_search.medium;

/**
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Task 153</a>
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= nums[0] && nums[mid] < nums[nums.length - 1]) {
                return nums[0];
            }
            if (nums[mid] >= nums[0] && nums[mid] > nums[nums.length - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
