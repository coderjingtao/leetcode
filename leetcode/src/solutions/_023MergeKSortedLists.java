package solutions;

/**
 * NO.23 Merge k Sorted Lists
 * Keywords:   Linked List
 * Difficulty: Hard
 * Company:    Google, Facebook, Linkedin, Microsoft, Amazon, Uber, Airbnb
 * todo need a better solution
 */
public class _023MergeKSortedLists {

    /**
     * Solution 1:
     * Merge lists one by one
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];

        ListNode l1 = lists[0];
        for(int i=1; i< lists.length; i++){
            ListNode l2 = lists[i];
            ListNode myhead = new ListNode(0);
            ListNode curr = myhead;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    curr.next = l1;
                    l1 = l1.next;
                }else{
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
            l1 = myhead.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        _023MergeKSortedLists m = new _023MergeKSortedLists();
        int[] num1 = {1,4,5};
        int[] num2 = {1,3,4};
        int[] num3 = {2,6};
        ListNode l1 = LinkedListTools.createLinkedList(num1);
        ListNode l2 = LinkedListTools.createLinkedList(num2);
        ListNode l3 = LinkedListTools.createLinkedList(num3);
        ListNode[] lists = {l1,l2,l3};
        ListNode result = m.mergeKLists(lists);
        LinkedListTools.printLinkedList(result);
    }
}
