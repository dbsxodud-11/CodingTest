package Data_Structure.PriorityQueue;

import java.lang.Comparable;

public class MaxPriorityQueue<E extends Comparable<E>> {
    
    //Binary heap;
    private static final int CAPACITY = 16;
    private int size;
    private E[] binary_heap;

    public MaxPriorityQueue(){
        binary_heap = (E[]) new Comparable[CAPACITY];
        size = 0;
    }

    public void insert(E element){
        //Bottom-up Reheapify
        binary_heap[++size] = element;
        swim(size);
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    public E delMax(){
        //Top-down Reheapify
        E max = binary_heap[1];
        exch(1, size--);
        sink(1);
        binary_heap[size+1] = null;
        return max;
    }

    private void sink(int k){
        while(2*k <= size){
            //choose left or right child
            int j = 2*k;
            if(j < size && less(j , j+1)) j++;
            if(!less(k, j)) break; // find a position
            k = j;
        }
    }

    public E max(){
        return binary_heap[1];
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
