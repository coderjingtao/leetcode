package solutions;

/**
 * NO.21 Merge Two Sorted Lists
 * Keywords:   Linked List
 * Difficulty: Easy
 * Company:    Linkedin, Microsoft, Amazon, Apple
 */
public class _021MergeTwoSortedLists {
    /**
     * Idea: 当l1和l2都不为空时，比较大小后，依次放入
     * 当有一方为空时，把当前的指针的下一位指向另一方
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode myhead = new ListNode(0);
        ListNode curr = myhead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null){
            curr.next = l2;
        }
        if(l2 == null){
            curr.next = l1;
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode l1 = LinkedListTools.createLinkedList(nums1);
        ListNode l2 = LinkedListTools.createLinkedList(nums2);
        LinkedListTools.printLinkedList(l1);
        LinkedListTools.printLinkedList(l2);
        _021MergeTwoSortedLists m = new _021MergeTwoSortedLists();
        ListNode head = m.mergeTwoLists(l1, l2);
        LinkedListTools.printLinkedList(head);
    }
}
