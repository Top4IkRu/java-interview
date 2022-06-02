package solution.arrays.easy;

/**
 * @see <a href="https://leetcode.com/problems/valid-anagram/">Task 242</a>
 */
public class ValidAnagram {

    /**
     * Space - O(1)
     * Time - O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int n : arr) if (n != 0) return false;
        return true;
    }
}
