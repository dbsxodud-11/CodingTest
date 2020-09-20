package Data_Structure.PriorityQueue;

import java.lang.Comparable;

public class MinPriorityQueue<E extends Comparable<E>> {
    
    //Binary heap
    private static final int CAPACITY = 16;
    private int size;
    private E[] binary_heap;

    public MinPriorityQueue(){
        binary_heap = (E[]) new Comparable[CAPACITY];
        size = 0;
    }

    public void insert(E element){
        //Bottom-up Reheapify
        binary_heap[++size] = element;
        swim(size);
    }

    private void swim(int k){
        while(k > 1 && less(k, k/2)){
            exch(k, k/2);
            k = k/2;
        }
    }

    public E min(){
        return binary_heap[1];
    }

    public E delMin(){
        //Top-down Reheapify
        E min = binary_heap[1];
        exch(1, size--);
        binary_heap[size+1] = null;
        sink(1);

        return min;
    }

    private void sink(int k){
        while(k*2 < size){
            int j = k*2;
            if(j < size && less(j+1, j)) j++;
            if(less(k, j)) break;
            k = j;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    private boolean less(int a, int b){
        return binary_heap[a].compareTo(binary_heap[b]) < 0;
    }

    private void exch(int a, int b){
        E temp = binary_heap[a];
        binary_heap[a] = binary_heap[b];
        binary_heap[b] = temp;
    }
}
