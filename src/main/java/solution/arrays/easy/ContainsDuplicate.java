package solution.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Task 217</a>
 */
public class ContainsDuplicate {

    /**
     * Space - O(n)
     * Time - O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            if (!cache.add(num)) return true;
        }
        return false;
    }

    /**
     * Space - O(1)
     * Time - O(n*log(n))
     */
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}
