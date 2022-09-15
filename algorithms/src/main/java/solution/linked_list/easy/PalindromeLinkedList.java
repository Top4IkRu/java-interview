package solution.linked_list.easy;

import solution.linked_list.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">Task 234</a>
 */
public class PalindromeLinkedList {

    /**
     * With two pointers
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * With extra memory
     */
    public boolean isPalindrome_2(ListNode head) {
        StringBuilder builder = new StringBuilder();

        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }

        String s = builder.toString();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
