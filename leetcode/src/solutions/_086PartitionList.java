package solutions;

import java.util.ArrayList;

/**
 * NO.86 Partition List
 * Keywords:   Linked List
 * Difficulty: Medium
 * Company:
 * todo need a better solution
 */
public class _086PartitionList {
    /**
     * 思路：把LinkedList按照与x的比较值，分成小于x和大于等于x的2个list
     * 再把两个list的头尾相连，形成一个新的LinkedList
     * 时间复杂度 O(2*nodes)
     * 空间复杂度 O(nodes)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        ArrayList<ListNode> lessList = new ArrayList<ListNode>();
        ArrayList<ListNode> greaterList = new ArrayList<ListNode>();
        while(curr != null){
            if(curr.val < x)
                lessList.add(curr);
            else
                greaterList.add(curr);
            curr = curr.next;
        }
        ListNode[] pair1 = createByList(lessList);
        ListNode[] pair2 = createByList(greaterList);
        return combineTwoList(pair1,pair2);
    }

    private ListNode[] createByList(ArrayList<ListNode> list){
        if(list.isEmpty())
            return null;
        ListNode[] pair = new ListNode[2];
        ListNode head = list.get(0);
        ListNode curr = head;
        for(int i = 1; i < list.size(); i++){
            curr.next = list.get(i);
            curr = curr.next;
        }
        pair[0] = head;
        pair[1] = curr;
        return pair;
    }

    private ListNode combineTwoList(ListNode[] pair1, ListNode[] pair2){
        ListNode head = null, tail = null;
        if(pair1 != null && pair2 == null){
            head = pair1[0];
            tail = pair1[1];
            tail.next = null;
        }
        if(pair1 == null && pair2 != null){
            head = pair2[0];
            tail = pair2[1];
            tail.next = null;
        }
        if(pair1 != null && pair2 != null){
            head = pair1[0];
            tail = pair1[1];
            ListNode head1 = pair2[0];
            ListNode tail1 = pair2[1];
            tail.next = head1;
            tail1.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        _086PartitionList p = new _086PartitionList();
        int[] nums = {1,4,3,2,5,2};
        ListNode head = LinkedListTools.createLinkedList(nums);
        LinkedListTools.printLinkedList(head);
        ListNode newhead = p.partition(head, 4);
        LinkedListTools.printLinkedList(newhead);
    }
}
