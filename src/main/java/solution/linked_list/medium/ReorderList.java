package solution.linked_list.medium;

import solution.linked_list.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/reorder-list/">Task 143</a>
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Find middle of list with slow and fast pointer
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second part of the list
        // [1 -> 2 -> 3 -> 4 -> 5 -> 6] -> [1 -> 2 -> 3] and [6 -> 5 -> 4]
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // Merge two lists [1 -> 2 -> 3] and [6 -> 5 -> 4]
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp;
            first = tmp;
            second = tmp2;
        }
    }
}
