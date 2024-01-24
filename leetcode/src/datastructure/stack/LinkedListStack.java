package datastructure.stack;

import basic.ListNode;

/**
 * 基于链表实现的栈
 * @author joseph
 * @create 2024-01-24
 */
public class LinkedListStack {

    private ListNode head;
    private int size = 0;

    public LinkedListStack(){
        head = null;
    }
    public int size(){
        return size;
    }

    public void push(int num){
        ListNode p = new ListNode(num);
        p.next = head;
        head = p;
        size++;
    }

    public int peek(){
        if(head == null){
            throw new IndexOutOfBoundsException("stack is empty");
        }
        return head.val;
    }

    public int pop(){
        int num = peek();
        head = head.next;
        size--;
        return num;
    }

    public int[] toArray(){
        ListNode node = head;
        int[] arr = new int[size];
        for(int i = arr.length-1; i >= 0; i--){
            arr[i] = node.val;
            node = node.next;
        }
        return arr;
    }
}
