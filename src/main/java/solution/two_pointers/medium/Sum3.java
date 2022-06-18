package solution.two_pointers.medium;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/3sum/">Task 15</a>
 */
public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l - 1] == nums[l]) l++;
                    while (l < r && nums[r + 1] == nums[r]) r--;
                } else if (sum > 0) {
                    r--;
                    while (l < r && nums[r + 1] == nums[r]) r--;
                } else {
                    l++;
                    while (l < r && nums[l - 1] == nums[l]) l++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
