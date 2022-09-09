package solution.greedy.medium;

/**
 * @see <a href="https://leetcode.com/problems/jump-game-ii">Task 45</a>
 */
public class JumpGame2 {

    public static int jump(int[] nums) {
        int currentJumpEnd = 0;
        int farthestJumpEnd = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthestJumpEnd = Math.max(farthestJumpEnd, i + nums[i]);

            if (farthestJumpEnd == nums.length - 1) return ++jumps;

            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthestJumpEnd;
            }
        }

        return jumps;
    }
}
