package solutions;

/**
 * NO.206 Reverse Linked List
 * Keywords:   Linked List
 * Difficulty: Easy
 * Company:    Facebook, Microsoft, Amazon, Uber, Yelp, Apple, Bloomberg, Yahoo, Snapchat
 */
public class _206ReverseLinkedList {
    /**
     * Original:         1 -->2 -->3 -->4 -->5 --> Null
     * Reversed: Null <--1 <--2 <--3 <--4 <--5
     * return the head node of the new linked list
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while( curr != null ){
            ListNode next = curr.next;
            // 1. reverse operation
            curr.next = prev;
            // 2. move pointer
            prev = curr; // prev --> curr
            curr = next; // curr --> next
        }
        return prev; // when curr == null, prev node is the head node.
    }

    public static void main(String[] args) {
        _206ReverseLinkedList r = new _206ReverseLinkedList();
        int[] nums = {1,2,3,4,5};
        ListNode head = LinkedListTools.createLinkedList(nums);
        LinkedListTools.printLinkedList(head);
        ListNode newHead = r.reverseList(head);
        LinkedListTools.printLinkedList(newHead);
    }
}
