package solution.stack.easy;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">Task 20</a>
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char lastOpen = stack.pop();

                if (lastOpen == '(' && c != ')') return false;
                if (lastOpen == '{' && c != '}') return false;
                if (lastOpen == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }
}
