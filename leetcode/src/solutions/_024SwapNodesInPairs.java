package solutions;

/**
 * NO.24 Swap Nodes in Pairs
 * Keywords:   Linked List
 * Difficulty: Medium
 * Company:    Microsoft, Uber, Bloomberg
 */
public class _024SwapNodesInPairs {

    /**
     * Solution:
     * initialize the current pointer p to myhead (dummy head)
     * Original:          myhead --> node1 --> node2 --> next
     * After one swap:    myhead --> node2 --> node1 --> next
     * then put the current pointer p to the node1
     *
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode swapPairs(ListNode head) {

        ListNode myhead = new ListNode(0);
        myhead.next = head;
        ListNode p = myhead;

        while(p.next != null && p.next.next != null ){
            //1.Get the initial value
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next; // maybe null, it doesn't matter
            //2.Swap the first 3 nodes
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            //3.Change the current pointer p to the node1
            p = node1;
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        _024SwapNodesInPairs s = new _024SwapNodesInPairs();
        int[] nums = {1,2,3,4};
        ListNode head = LinkedListTools.createLinkedList(nums);
        ListNode newHead = s.swapPairs(head);
        LinkedListTools.printLinkedList(newHead);
    }

}
