package solutions;

/**
 * NO.19 Remove Nth Node From End of List
 * Keywords:   linked list, double pointer
 * Difficulty: Medium
 * Company:
 */
public class _019RemoveNthNodeFromEndOfList {
    /**
     * Solution 1: 2次遍历
     * 由于整个的链表长度未知，因此需要首先遍历一遍链表，取得链表的长度这样就可以删除掉倒数第n个元素了
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len ++;
            curr = curr.next;
        }
        int target = len - n;
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        curr = myHead;
        int counter = 0;
        while(curr != null){
            if(counter == target){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
            counter ++;
        }
        return myHead.next;
    }

    /**
     * Solution 2: 双指针一次遍历 double pointer
     * 把两个指针之间的间隔设置为n+1,当后指针到达链表的末尾null时，前指针指的位置即为要删除的节点的前一个节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        ListNode firstNode = myHead;
        ListNode secondNode = myHead;
        while(n >= 0){
            secondNode = secondNode.next;
            n--;
        }
        while(secondNode != null){
            secondNode = secondNode.next;
            firstNode = firstNode.next;
        }
        firstNode.next = firstNode.next.next;
        return myHead.next;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = LinkedListTools.createLinkedList(nums);
        LinkedListTools.printLinkedList(head);
        _019RemoveNthNodeFromEndOfList r = new _019RemoveNthNodeFromEndOfList();
        head = r.removeNthFromEnd2(head,5);
        LinkedListTools.printLinkedList(head);

    }
}
