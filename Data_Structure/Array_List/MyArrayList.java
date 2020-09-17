package Data_Structure.Array_List;

import java.lang.Iterable;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E>{
    
    public static final int CAPACITY = 16;
    private E[] data;
    private int size;

    public MyArrayList(){
        data = (E[]) new Object[CAPACITY];
        size = 0;
    }

    //Dynamic Array
    public boolean checkSize(int index, int n){
        if (index < 0 || index >= n) return false;
        else return true;
    }

    public void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for(int i=0; i<size; i++){
            temp[i] = data[i];
        }
    }

    public void add(int index, E element){
        if(!checkSize(index, size+1)) return;
        if(size == data.length){
            resize(data.length*2);
        }
        for(int i = size-1; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public E remove(int index){
        if(!checkSize(index, size+1)) return null;
        E element = data[index];
        for(int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        data[size-1] = null; //help garbage collection
        size--;
        if(size == data.length/4) resize(data.length/2);
        return element;
    }

    public E get(int index){
        if(!checkSize(index, size+1)) return null;
        return data[index];
    }

    public E set(E element, int index){
        if(!checkSize(index, size+1)) return null;
        else{
            E old = data[index];
            data[index] = element;
            return old;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    //Iterator
    public Iterator<E> iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E>{
        private int j=0;

        public boolean hasNext(){
            return j<size;
        }

        public E next(){
            if(!hasNext()) return null;
            return data[j++];
        }
    }
}
