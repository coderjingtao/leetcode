package basic;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Description: learn priority queue in java
 * Created by Jingtao Liu on 14/03/2019.
 */
public class MyPriorityQueue {

    public void testPriorityQueue(){//默认是最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<10; i++){
            Random random = new Random();
            pq.add(random.nextInt(10));
        }
        while(!pq.isEmpty()){
            System.out.println(pq.remove()); //pq.poll()
        }
    }

    public void testPriorityQueue2(){//修改成最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<10; i++){
            Random random = new Random();
            pq.add(random.nextInt(10));
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    public void testPriorityQueue3(){//修改成最大堆 for java8
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);
        for(int i=0; i<10; i++){
            Random random = new Random();
            pq.add(random.nextInt(10));
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    public static void main(String[] args) {
//        MyPriorityQueue mpq = new MyPriorityQueue();
//        mpq.testPriorityQueue3();
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        System.out.println(pq.size());
    }
}
