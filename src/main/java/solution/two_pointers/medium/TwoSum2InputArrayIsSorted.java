package solution.two_pointers.medium;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Task 167</a>
 */
public class TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
