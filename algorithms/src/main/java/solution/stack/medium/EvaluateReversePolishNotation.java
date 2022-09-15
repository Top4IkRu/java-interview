package solution.stack.medium;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Task 150</a>
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int r = stack.pop();
                    int l = stack.pop();
                    stack.push(l - r);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
