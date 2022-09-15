package solution.linked_list.easy;

import solution.linked_list.ListNode;

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
}
