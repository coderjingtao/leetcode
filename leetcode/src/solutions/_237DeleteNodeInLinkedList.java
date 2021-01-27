package solutions;

/**
 * NO.237 Delete Node in a Linked List
 * Keywords:   linked list
 * Difficulty: Easy
 * Company:    Microsoft, Apple
 */
public class _237DeleteNodeInLinkedList {
    /**
     * Solution：
     * 之前解决删除curr节点的问题，是通过把链表 prev --> curr ---> next 的prev.next指针指向next即可
     * 但该题比较特殊，给定的节点就是要删除的节点，因为无法取得它之前的节点，所以不能立即使用指针的方式进行求解
     * 该题的解决方案如下：
     * deletingNode ---> nextNode ---> 3rdNode
     * 1.把deletingNode下一个节点nextNode的值赋给当前要删除节点deletingNode
     * 2.然后把deletingNode的next指针，指向3rdNode
     * 这样做，本质上是把nextNode删除掉了，但nextNode的值提前赋给了deletingNode，看起来像把deletingNode删除掉了
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void deleteNode(ListNode node) {
        if(node == null)
            throw new IllegalArgumentException("The given node is not a valid node");
        if(node.next == null)
            throw new IllegalArgumentException("The given node is the tail");
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //test
    public static void main(String[] args) {
        int[] nums = {4,5,1,9,2,3,6};
        ListNode head = LinkedListTools.createLinkedList(nums);
        LinkedListTools.printLinkedList(head);
        _237DeleteNodeInLinkedList d = new _237DeleteNodeInLinkedList();
        d.deleteNode(head.findNode(6));
        LinkedListTools.printLinkedList(head);
    }
}
