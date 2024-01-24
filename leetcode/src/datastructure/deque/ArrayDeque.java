package datastructure.deque;

/**
 * 基于数组实现的双向队列
 * @author joseph
 * @create 2024-01-24
 */
public class ArrayDeque {
    private final int capacity;
    private int head = 0, size = 0;
    private final int[] arr;

    public ArrayDeque(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    //计算环形数组索引
    private int index(int i){
        return (i + capacity) % capacity;
    }

    public void push_first(int num){
        if(size() == capacity){
            throw new IndexOutOfBoundsException("deque is full");
        }
        head = index(head - 1);
        arr[head] = num;
        size++;
    }
    public void push_last(int num){
        if(size() == capacity){
            throw new IndexOutOfBoundsException("deque is full");
        }
        int tailIndex = index(head + size);
        arr[tailIndex] = num;
        size++;
    }
    public int peek_first(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("deque is empty");
        }
        return arr[head];
    }
    public int pop_first(){
        int num = peek_first();
        head = index(head + 1);
        size--;
        return num;
    }
    public int peek_last(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("deque is empty");
        }
        int tailIndex = index(head + size - 1);
        return arr[tailIndex];
    }
    public int pop_last(){
        int num = peek_last();
        size--;
        return num;
    }
    //仅转换有效长度范围内的列表元素
    public int[] toArray(){
        int[] res = new int[size];
        for(int i = 0, j = head; i < res.length; i++,j++){
            res[i] = arr[index(j)];
        }
        return res;
    }

}
