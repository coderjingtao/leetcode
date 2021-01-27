package solutions;

/**
 * NO.203 Remove Linked List Elements
 * Keywords:   Linked List
 * Difficulty: Easy
 * Company:
 */
public class _203RemoveLinkedListElements {
    /**
     * 由于删除元素时要比较每一个元素的值，包括头节点，但while循环无法比较头节点
     * 因此需要设立一个虚拟头节点，让其指向真实的头节点即可
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while(curr.next != null){ //如果curr=head,这种情况无法处理头节点，所以需要设置虚拟头节点
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        int val = 6;
        _203RemoveLinkedListElements r = new _203RemoveLinkedListElements();
        ListNode head = LinkedListTools.createLinkedList(nums);
        LinkedListTools.printLinkedList(head);
        ListNode head1 = r.removeElements(head, val);
        LinkedListTools.printLinkedList(head1);
    }
}
