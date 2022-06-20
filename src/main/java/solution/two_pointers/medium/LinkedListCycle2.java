package solution.two_pointers.medium;

/**
 * @see solution.linkedlist.easy.LinkedListCycle
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Task 142</a>
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
