package solution.two_pointers.easy;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Task 125</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome_1(String s) {
        char[] chars = s
                .toLowerCase()
                .trim()
                .replaceAll("[^a-zA-Z0-9]", "")
                .toCharArray();

        for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
            if (chars[left] != chars[right]) return false;
        }
        return true;
    }

    public boolean isPalindrome_2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) i++;
            while (!Character.isLetterOrDigit(s.charAt(j)) && j > i) j--;

            if (i > j || Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;

            i++;
            j--;
        }
        return true;
    }
}
