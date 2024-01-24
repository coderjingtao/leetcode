package datastructure.stack;

import java.util.ArrayList;

/**
 * 基于ArrayList实现的栈
 * @author joseph
 * @create 2024-01-24
 */
public class ArrayStack {
    private ArrayList<Integer> list;
    public ArrayStack(){
        list = new ArrayList();
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(int num){
        list.add(num);
    }

    public int peek(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("stack is empty");
        return list.get(list.size()-1);
    }

    public int pop(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("stack is empty");
        return list.remove(list.size()-1);
    }

    public Object[] toArray(){
        return list.toArray();
    }
}
