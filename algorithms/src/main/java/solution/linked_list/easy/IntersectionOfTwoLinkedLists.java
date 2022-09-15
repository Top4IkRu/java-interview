package solution.linked_list.easy;

import solution.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Task 160</a>
 */
// TODO check again interesting approach with swap tmp in the end
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmpA = headA;
        ListNode tmpB = headB;

        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }
        return tmpA;
    }

    /**
     * With extra space
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            set.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (set.contains(tmp)) return tmp;
            tmp = tmp.next;
        }
        return null;
    }
}
