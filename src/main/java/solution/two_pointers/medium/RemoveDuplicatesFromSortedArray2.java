package solution.two_pointers.medium;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">Task 80</a>
 */
public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        markBadPositions(nums);
        int i = 0;
        while (i < nums.length && nums[i] != Integer.MIN_VALUE) i++;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != Integer.MIN_VALUE) nums[i++] = nums[j];
        }
        return i;
    }

    /**
     * Если элемент повторяется больше 2х раз, то заменяем его на Integer.MIN_VALUE
     */
    private void markBadPositions(int[] nums) {
        int prev = Integer.MIN_VALUE;
        int prevCount = 0;
        int pos = 0;

        while (pos < nums.length) {
            if (nums[pos] != prev) {
                prev = nums[pos];
                prevCount = 1;
            } else {
                prevCount++;
            }

            if (prevCount > 2) nums[pos] = Integer.MIN_VALUE;
            pos++;
        }
    }
}
