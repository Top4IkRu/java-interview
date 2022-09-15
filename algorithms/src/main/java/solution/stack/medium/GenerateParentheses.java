package solution.stack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Task 22</a>
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, n - 1, 1, "(");
        return result;
    }

    private void generateParenthesis(List<String> result, int forOpen, int opened, String prefix) {
        if (forOpen == 0) {
            result.add(prefix + ")".repeat(Math.max(0, opened)));
            return;
        }

        if (forOpen > 0) {
            generateParenthesis(result, forOpen - 1, opened + 1, prefix + "(");
        }

        if (opened > 0) {
            generateParenthesis(result, forOpen, opened - 1, prefix + ")");
        }
    }
}
