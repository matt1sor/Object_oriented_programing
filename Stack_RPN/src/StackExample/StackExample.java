package StackExample;
import java.util.EmptyStackException;

public class StackExample<T> {

    private final T[] arrStack;
    private int topOfStack;
    private final int capacity;

    StackExample(int size){
        arrStack = (T[]) new Object[size];
        this.capacity = size;
        this.topOfStack = -1;
    }

    public Boolean empty(){
        return topOfStack == -1;
    }

    public Integer capacityOfStack(){
        return capacity;
    }

    public Integer sizeOfStack(){
        return topOfStack + 1;
    }


    public void push(T x){
        arrStack[++topOfStack] = x;
    }

    public T pop(){
        if  (empty()) throw new EmptyStackException();
        return arrStack[topOfStack--];

    }

    public T peek(){
        if  (empty()) throw new EmptyStackException();
        return arrStack[topOfStack];

    }



}
