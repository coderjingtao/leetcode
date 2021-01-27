package solutions;

/**
 * Description: The linked list testing tool for creating and printing one linked list
 * Created by Jingtao Liu on 26/02/2019.
 */
public class LinkedListTools {

    public static ListNode createLinkedList(int[] nums){
        if(nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;// moving pointer
        for(int i = 1; i < nums.length; i++){
            curr.next = new ListNode(nums[i]); //1.将当前元素的下一个元素指定为新元素
            curr = curr.next; //2.将当前元素指针指向下一个元素
        }
        return head;
    }

    public static void printLinkedList(ListNode node){
        while(node != null){
            System.out.print(node + " --> ");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
