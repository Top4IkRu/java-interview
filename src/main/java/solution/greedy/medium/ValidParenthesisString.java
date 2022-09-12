package solution.greedy.medium;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/valid-parenthesis-string">Task 678</a>
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Integer> openBracketIndexes = new Stack<>();
        Stack<Integer> starIndexes = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '(':
                    openBracketIndexes.push(i);
                    break;
                case ')':
                    if (openBracketIndexes.size() > 0) openBracketIndexes.pop(); // if we have brackets
                    else if (starIndexes.size() > 0) starIndexes.pop(); // if not brackets do we have stars
                    else return false; // closing bracket without opening and star
                    break;
                default:
                    starIndexes.push(i);
            }
        }
        // if we left with some opening bracket that over stars con cover up
        while (openBracketIndexes.size() > 0 && starIndexes.size() > 0) {
            if (openBracketIndexes.peek() > starIndexes.peek()) return false;
            openBracketIndexes.pop();
            starIndexes.pop();
        }

        return openBracketIndexes.size() == 0;
    }
}
