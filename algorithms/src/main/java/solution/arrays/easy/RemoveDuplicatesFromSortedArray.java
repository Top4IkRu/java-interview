package solution.arrays.easy;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Task 26</a>
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Space - O(1)
     * Time - O(n)
     */
    public int removeDuplicates(int[] nums) {
        int tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[tmp]) {
                tmp++;
                nums[tmp] = nums[i];
            }
        }
        return ++tmp;
    }

    /**
     * Space - O(1)
     * Time - O(n)
     */
    public static int removeDuplicates_2(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;
        int fast = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
