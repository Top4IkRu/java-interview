package solution.linked_list.easy;

import solution.linked_list.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">Task 203</a>
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode start = null;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val == val) {
                if (prev != null) {
                    prev.next = tmp.next;
                }
            } else {
                if (start == null) {
                    start = tmp;
                }
                prev = tmp;
            }
            tmp = tmp.next;
        }
        return start;
    }
}
