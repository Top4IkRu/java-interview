package solution.linked_list.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Task 138</a>
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node origNode = head;
        Node newHead = null;
        Node copyPrev = null;
        while (origNode != null) {
            Node copy = map.getOrDefault(origNode, new Node(origNode.val));
            map.put(origNode, copy);

            if (newHead == null) newHead = copy;
            if (copyPrev != null) copyPrev.next = copy;

            if (origNode.random != null) {
                Node randomCopy = map.getOrDefault(origNode.random, new Node(origNode.random.val));
                copy.random = randomCopy;
                map.put(origNode.random, randomCopy);
            }

            copyPrev = copy;
            origNode = origNode.next;
        }
        copyPrev.next = null;
        return newHead;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
