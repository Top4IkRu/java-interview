package solution.two_pointers.easy;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/">Task 680</a>
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        return validator(s, 0, s.length() - 1, false);
    }

    boolean validator(String s, int i, int j, boolean deleted) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                if (deleted) return false;
                return validator(s, i + 1, j, true) || validator(s, i, j - 1, true);
            }
        }
        return true;
    }
}
