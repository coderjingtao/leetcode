package datastructure.queue;

import basic.ListNode;

/**
 * 基于链表实现的队列
 * @author joseph
 * @create 2023-12-13
 */
public class LinkedListQueue {

    private ListNode head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
    }

    public void push(int num){
        ListNode node = new ListNode(num);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int pop(){
        int num = peek();
        head = head.next;//删除头节点
        size--;
        return num;
    }
    //访问队首元素
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int[] toArray(){
        ListNode node = head;
        int[] res = new int[size];
        for(int i = 0; i < res.length; i++){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
