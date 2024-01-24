package datastructure.deque;

import basic.ListNode2;

/**
 * 基于双向链表实现的双向队列
 * @author joseph
 * @create 2024-01-24
 */
public class LinkedListDeque {

    private ListNode2 head, rear;
    int size = 0;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    private void push(int num, boolean fromHead){
        ListNode2 p = new ListNode2(num);
        if(isEmpty()){
            head = rear = p;
        }else if(fromHead){
            head.prev = p;
            p.next = head;
            head = p;
        }else{
            rear.next = p;
            p.prev = rear;
            rear = p;
        }
        size++;
    }

    public void push_first(int num){
        push(num,true);
    }
    public void push_last(int num){
        push(num,false);
    }
    public int peek_first(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("deque is empty");
        }
        return head.val;
    }

    public int pop_first(){
        int num = peek_first();
        ListNode2 hNext = head.next;
        if(hNext != null){
            //断开头节点
            hNext.prev = null;
            head.next = null;
        }
        head = hNext;
        size--;
        return num;
    }

    public int peek_last(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("deque is empty");
        }
        return rear.val;
    }

    public int pop_last(){
        int num = peek_last();
        ListNode2 rPrev = rear.prev;
        if(rPrev != null){
            //断开尾节点
            rPrev.next = null;
            rear.prev = null;
        }
        rear = rPrev;
        size--;
        return num;
    }

    public int[] toArray(){
        ListNode2 node = head;
        int[] arr = new int[size()];
        for(int i= 0; i < arr.length; i++){
            arr[i] = node.val;
            node = node.next;
        }
        return arr;
    }
}
