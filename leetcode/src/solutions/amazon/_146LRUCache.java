package solutions.amazon;

import basic.ListNode;

import java.util.*;

/**
 * NO.146 LRU Cache
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _146LRUCache {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        int val = cache.get(1);
        System.out.println(val);
        val = cache.get(2);
        System.out.println(val);
    }
}

class LRUCache {
    private ListNode head, tail;
    private final Map<Integer,Integer> map;
    private int size = 0;
    private final int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }
    public int size(){
        return size;
    }
    public int capacity(){
        return capacity;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return head.val;
    }
    public int pop(){
        int key = peek();
        head = head.next;
        map.remove(key);
        size--;
        return key;
    }
    public void put(int key, int value){
        ListNode node = new ListNode(key);
        if(map.containsKey(key)){//key exists in queue
            remove(key);//remove the key
        }else if(size() == capacity()){//key doesn't exist in queue but queue is full. Pop the head first.
            pop();
        }
        push(node);
        map.put(key,value);
        size++;
    }
    public int get(int key){
        Integer val = map.get(key);
        if(val != null){
            put(key,val);
            return val;
        }
        return -1;
    }
    /**
     * search the node of key
     * @param key key must be in the queue
     * @return the previous node of key node
     */
    private ListNode search(int key){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == key){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    /**
     * search key node and remove it from queue
     * @param key key must in the queue
     */
    private void remove(int key){
        ListNode prev = search(key);
        //key is head
        if(prev == null){
            head = head.next;
        }
        //key is tail
        else if(prev.next.next == null){
            prev.next = null;
            tail = prev;
        }
        else{
            prev.next = prev.next.next;
        }
        size--;
    }
    /**
     * push the node with the val to the tail of the queue
     * @param node
     */
    private void push(ListNode node){
        if(head == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }
    public int[] toArray(){
        ListNode node = head;
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}

/**
 * 参考labuladong笔记,用java的LinkedHashMap实现
 * @author joseph
 * @create 2023-12-14
 */
class LRUCache2 {
    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;
    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    public int get(int key) {
        Integer val = cache.get(key);
        if (val != null) {
            cache.remove(key);
            cache.put(key, val);
        }
        return val == null ? -1 : val;
    }
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() == capacity) {
            //remove the 1st key from cache
            Integer firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, val);
    }
}