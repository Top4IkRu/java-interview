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

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;

        int startIndex = 1;
        // count the time of duplicate numbers occurence
        int precCounter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (precCounter < 2) {
                    nums[startIndex++] = nums[i];
                }
                precCounter++;
            } else {
                precCounter = 1;
                nums[startIndex++] = nums[i];
            }
        }
        return startIndex;
    }
}
