package solution.two_pointers.easy;

/**
 * @see <a href="https://leetcode.com/problems/reverse-string/">Task 344</a>
 */
public class ReverseString {
    /**
     * Modify s in-place
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
