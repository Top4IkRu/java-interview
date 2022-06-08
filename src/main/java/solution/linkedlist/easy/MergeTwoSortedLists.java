package solution.linkedlist.easy;

import solution.linkedlist.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Task 21</a>
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists_1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tmp.next = list2;
                list2 = null;
                continue;
            }

            if (list2 == null) {
                tmp.next = list1;
                list1 = null;
                continue;
            }

            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        return head.next;
    }

    /**
     * Recursion
     */
    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists_2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_2(list2.next, list1);
            return list2;
        }
    }
}
