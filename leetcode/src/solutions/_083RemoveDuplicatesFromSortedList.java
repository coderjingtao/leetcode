package solutions;

/**
 * NO.83 Remove Duplicates from Sorted List
 * Keywords:   Linked List
 * Difficulty: Easy
 * Company:
 */
public class _083RemoveDuplicatesFromSortedList {
    /**
     * 思路：由于整个链表是有序的，所以从头元素开始找到它的下一个不相等的元素
     * 把它的下一个指针指向这个不相等的元素，并且当前指针curr移位到这个不相等的元素上
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;
        while(curr != null){
            ListNode nextDiffNode = nextDiffNode(curr);
            curr.next = nextDiffNode;
            curr = curr.next;
        }
        return head;
    }

    private ListNode nextDiffNode(ListNode curr){
        ListNode next = curr.next;
        while(next != null){
            if(next.val != curr.val)
                return next;
            next = next.next;
        }
        return next;
    }


    /**
     * 改进：以下一个节点next当作循环条件
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) //保证了链表中至少有2个元素
            return head;
        ListNode curr = head;
        while(curr.next != null){
            if(curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }


    public static void main(String[] args) {
        _083RemoveDuplicatesFromSortedList r = new _083RemoveDuplicatesFromSortedList();
        ListNode head = LinkedListTools.createLinkedList(new int[]{1,1,2,3,3});
        LinkedListTools.printLinkedList(head);
        ListNode head2 = r.deleteDuplicates2(head);
        LinkedListTools.printLinkedList(head2);
    }
}
