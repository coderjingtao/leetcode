package datastructure.queue;

/**
 * 基于数组实现的队列
 * 由于删除数组元素的时间负责度为O(n), 因此弹出首元素的操作效率很低；因此设计如下方案：
 * 维护2个变量：head(队首元素索引) 和 size(队列的长度)，因此队列的tail(队尾元素的下一个的索引) = head + size
 * 所以数组中维持整个队列元素的有效区间是[head, tail)
 *
 * 在不断进行入队和出队的过程中，head 和 tail 都在向右移动，当它们到达数组尾部时就无法继续移动了。为了解决此问题，我们可以将数组视为首尾相接的“环形数组”。
 * 对于环形数组，我们需要让 head 或 tail 在越过数组尾部时，直接回到数组头部继续遍历。这种周期性规律可以通过“取余操作”来实现
 *
 * 缺点：长度不可变
 * @author joseph
 * @create 2023-12-13
 */
public class ArrayQueue {
    private int[] nums;
    private int head;
    private int size;

    public ArrayQueue(int capacity){
        head = size = 0;
        nums = new int[capacity];
    }

    public void push(int num){
        if(size == capacity()){
            System.out.println("queue is full");
            return;
        }
        int tail = (head + size) % capacity();
        nums[tail] = num;
        size++;
    }

    public int pop(){
        int num = peek();
        head = (head + 1) % capacity();
        size--;
        return num;
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return nums[head];
    }
    public int capacity(){
        return nums.length;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int[] toArray(){
        int[] res = new int[size];
        for(int i = 0, j = head; i < size; i++, j++){
            res[i] = nums[j % capacity()];
        }
        return res;
    }
}
