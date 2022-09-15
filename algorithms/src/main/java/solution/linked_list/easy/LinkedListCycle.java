package solution.linked_list.easy;

import solution.linked_list.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Task 141</a>
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
