package solution.stack.medium;


/**
 * @see <a href="https://leetcode.com/problems/min-stack/">Task 155</a>
 */
public class MinStack {

    Node defaultNode = new Node();
    Node head;

    public MinStack() {
        head = defaultNode;
    }

    public void push(int val) {
        if (head == defaultNode) {
            head = new Node(val, defaultNode, val);
        } else {
            head = new Node(val, head, Math.min(val, head.min));
        }
    }

    public void pop() {
        if (head != defaultNode) {
            head = head.prev;
        }
    }

    public int top() {
        if (head == defaultNode) return 0;
        return head.val;
    }

    public int getMin() {
        if (head == defaultNode) return 0;
        return head.min;
    }

    private static class Node {
        int val;
        Node prev;
        int min;

        public Node() {
        }

        public Node(int val, Node prev, int min) {
            this.val = val;
            this.prev = prev;
            this.min = min;
        }
    }
}
