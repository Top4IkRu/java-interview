package solution.greedy.medium;

/**
 * @see <a href="https://leetcode.com/problems/jump-game/">Task 55</a>
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int[] arr = new int[nums.length];
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxStep) return false;
            if (i == 0 || arr[i] != 0) {
                maxStep = Math.max(maxStep, nums[i] + i);
                if (nums[i] + i >= nums.length - 1) return true;

                for (int j = 1; j <= nums[i]; j++) arr[i + j] += 1;
            }
        }
        return false;
    }

    public boolean canJump_2(int[] nums) {
        int reach = 0;
        for (int i = 0; i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (reach >= nums.length - 1) return true;
        }
        return false;
    }
}
