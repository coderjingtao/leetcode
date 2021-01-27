package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * NO.2 Add Two Numbers
 * Keywords:   Linked List
 * Difficulty: Medium
 * Company:    Microsoft, Amazon, Bloomberg
 * todo 需要换一个方法
 */
public class _002AddTwoNumbers {
    /**
     * Idea: 直觉上就是把每一个list转换成数字并相加，并将加和再转化为linked list
     * 但这个方法有个致命的缺陷，就是一旦有个list非常长，超出了long的精度（2^63-1）,该方法就不能用了
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = toNum(l1);
        long num2 = toNum(l2);
        System.out.println(num1 + num2);
        return toLinkedList(num1 + num2);
    }

    private long toNum(ListNode head){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode curr = head;
        int index = 0;
        while(curr != null){
            map.put( index, curr.val );
            curr = curr.next;
            index ++;
        }
        long sum = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            sum += (long)entry.getValue() * (long)Math.pow(10, entry.getKey());
        }
        return sum;
    }

    private ListNode toLinkedList(long num){
        if(num == 0)
            return new ListNode(0);
        ListNode myhead = new ListNode(0);
        ListNode curr = myhead;
        while(num != 0){
            long digit = num%10; //个位数
            curr.next = new ListNode((int)digit);
            curr = curr.next;
            num = num/10;
        }
        return myhead.next;
    }

    /**
     * Idea:
     * 依照题目，按照从左到右顺序相加，大于10后向右面进位
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ArrayList<Integer> list1 = new ArrayList<>();
        while(l1 != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        while(l2 != null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        int prev_digit = 0;
        int left = 0;
        int size = list1.size() <= list2.size() ? list1.size() : list2.size();
        ListNode myhead = new ListNode(0);
        ListNode curr = myhead;
        int i = 0;
        for( ; i < size; i++){
            int a = list1.get(i);
            int b = list2.get(i);
            left = a + b + prev_digit;
            if(left >= 10){
                prev_digit = left / 10;
                left = left % 10 ;
            }
            curr.next = new ListNode(left);
            curr = curr.next;
        }
        if(i >= list1.size()){
            for(;i<list2.size();i++){
                int b = list2.get(i);
                left = b + prev_digit;
                if(left >= 10){
                    prev_digit = left / 10;
                    left = left % 10 ;
                }
                curr.next = new ListNode(left);
                curr = curr.next;
            }
        }
        if(i >= list2.size()){
            for(;i<list1.size();i++){
                int a = list1.get(i);
                left = a + prev_digit;
                if(left >= 10){
                    prev_digit = left / 10;
                    left = left % 10 ;
                }
                curr.next = new ListNode(left);
                curr = curr.next;
            }
        }
        if(prev_digit>0){
            curr.next = new ListNode(prev_digit);
            curr = curr.next;
        }

        return myhead.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2){
        ListNode myhead = new ListNode(0);
        ListNode curr = myhead;
        int prev_digit = 0;
        int left = 0;
        while(l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            left = a + b + prev_digit;
            if(left >= 10){
                prev_digit = left / 10;
                left = left % 10 ;
            }else{
                prev_digit = 0;
            }
            curr.next = new ListNode(left);
            curr = curr.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(prev_digit > 0){
            curr.next = new ListNode(prev_digit);
            curr = curr.next;
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {9};
        int[] nums2 = {1,9,9,9,9,9,9,9,9,9};
//        int[] nums1 = {2,4,3};
//        int[] nums2 = {5,6,4};
        ListNode l1 = LinkedListTools.createLinkedList(nums1);
        ListNode l2 = LinkedListTools.createLinkedList(nums2);
        LinkedListTools.printLinkedList(l1);
        LinkedListTools.printLinkedList(l2);
        _002AddTwoNumbers a = new _002AddTwoNumbers();
		ListNode head = a.addTwoNumbers3(l1, l2);
		LinkedListTools.printLinkedList(head);

    }
}
