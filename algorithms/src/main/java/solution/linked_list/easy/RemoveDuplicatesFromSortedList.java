package solution.linked_list.easy;

import solution.linked_list.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Task 83</a>
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.val != tmp.next.val) {
                tmp = tmp.next;
            } else {
                tmp.next = tmp.next.next;
            }
        }
        return head;
    }
}
