package basic;

import java.util.Arrays;
import java.util.List;

/**
 * Description: ${Desc}
 * Created by Jingtao Liu on 3/01/2020.
 */
public class Test {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"售票窗口1");
        Thread thread2 = new Thread(myThread,"售票窗口2");
        Thread thread3 = new Thread(myThread,"售票窗口3");
        Thread thread4 = new Thread(myThread,"售票窗口4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println(6>>1);
    }
}
class MyThread implements Runnable{
    private int tickets = 200;
    Object lock = new Object();

    public void run(){

        while(true)
            synchronized (lock){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(tickets <= 0)
                    break;
                System.out.println(Thread.currentThread().getName() + " 剩余 " + tickets--);
        }
    }
}
