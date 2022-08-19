package solution.linked_list.medium;

/**
 * @see <a href="https://leetcode.com/problems/design-linked-list/">Task 707</a>
 */
class DesignLinkedList {

    public class MyLinkedList {

        class Link {
            Link prev;
            Link next;
            int value;

            public Link(int value) {
                this.value = value;
            }
        }

        /**
         * Initialize your data structure here.
         */
        Link head;
        Link tail;
        int size;

        public MyLinkedList() {
            head = new Link(Integer.MIN_VALUE);
            tail = new Link(Integer.MAX_VALUE);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            Link current = head;
            while (index-- >= 0) {
                current = current.next;
            }
            return current.value;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Link link = new Link(val);

            head.next.prev = link;
            link.next = head.next;

            head.next = link;
            link.prev = head;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Link link = new Link(val);
            //<--
            tail.prev.next = link;
            link.prev = tail.prev;
            //-->
            link.next = tail;
            tail.prev = link;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater
         * than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            } else if (index == 0) {
                addAtHead(val);
                return;
            } else if (index == size) {
                addAtTail(val);
                return;
            }

            Link current = head;
            Link link = new Link(val);
            while (index-- > 0) {
                current = current.next;
            }

            link.next = current.next;
            current.next.prev = link;

            current.next = link;
            link.prev = current;

            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            Link current = head;
            while (index-- >= 0) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }
}
