package solution.linkedlist.easy;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Task 206</a>
 */
public class ReverseLinkedList {

    /**
     * Recursion
     */
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode node, ListNode prev) {
        if (node == null) return prev;
        ListNode temp = node.next;
        node.next = prev;
        return reverseList(temp, node);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
