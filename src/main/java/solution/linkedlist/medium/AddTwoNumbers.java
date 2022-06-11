package solution.linkedlist.medium;

import solution.linkedlist.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Task 2</a>
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean extraOne = false;
        boolean l1Smaller = false;

        ListNode t1 = l1;
        ListNode p1 = null;
        ListNode t2 = l2;
        ListNode p2 = null;
        while (t1 != null || t2 != null) {
            int sum = 0;
            if (t1 == null) {
                sum = t2.val;
                l1Smaller = true;
            }
            if (t2 == null) sum = t1.val;
            if (t1 != null && t2 != null) sum = t1.val + t2.val;
            if (extraOne) sum += 1;
            extraOne = sum / 10 > 0;
            sum = sum % 10;
            if (t1 != null) {
                t1.val = sum;
                p1 = t1;
                t1 = t1.next;
            }
            if (t2 != null) {
                t2.val = sum;
                p2 = t2;
                t2 = t2.next;
            }
        }
        if (extraOne) {
            if (l1Smaller) {
                p2.next = new ListNode(1);
            } else {
                p1.next = new ListNode(1);
            }
        }
        return l1Smaller ? l2 : l1;
    }
}
