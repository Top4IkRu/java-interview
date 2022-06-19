package solution.two_pointers.medium;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Task 11</a>
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int tmp = Math.min(height[l], height[r]) * (r - l);
            if (tmp > result) {
                result = tmp;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
}
