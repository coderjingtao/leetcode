package solutions;

/**
 * Description: one node structure of singly-linked list
 * Created by Jingtao Liu on 26/02/2019.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode findNode(int x){
        ListNode curr = this;
        while(curr != null){
            if(curr.val == x)
                return curr;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
