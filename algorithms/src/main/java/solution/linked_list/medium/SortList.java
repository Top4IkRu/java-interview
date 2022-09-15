package solution.linked_list.medium;

import solution.linked_list.ListNode;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/sort-list/">Task 148</a>
 */
public class SortList {

    /**
     * Merge Sort Implementation
     *
     * @see <a href="https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/overview-of-merge-sort">Merge Sort article</a></a>
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // split in 2 parts
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    /**
     * Find middle with usage slow and fast pointers
     */
    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) tail.next = left;
        if (right != null) tail.next = right;

        return dummy.next;
    }

    /**
     * With extra space with usage PriorityQueue
     */
    public ListNode sortList_2(ListNode head) {
        if (head == null || head.next == null) return head;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode temp = head;
        while (temp.next != null) {
            queue.add(temp.val);
            temp = temp.next;
        }
        queue.add(temp.val);
        temp = head;
        //
        while (!queue.isEmpty()) {
            temp.val = queue.poll();
            temp = temp.next;
        }
        return head;
    }
}
