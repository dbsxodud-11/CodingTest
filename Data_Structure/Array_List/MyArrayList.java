package Data_Structure.Array_List;

public class MyArrayList<E> {
    
    private Object[] data;
    private int size;

    public MyArrayList(){
        data = new Object[100];
        size = 0;
    }

    //Dynamic Array
    public void checkSize(){
        if(size >= data.length){
            Object[] newdata = new Object[data.length*2];
            for(int i=0; i<size; i++){
                newdata[i] = data[i];
            }
            data = newdata;
        }
        else if(size < data.length/4){
            Object[] newdata = new Object[data.length/2];
            for(int i=0; i<size; i++){
                newdata[i] = data[i];
            }
            data = newdata;
        }
    }

    public void add(int index, Object element){
        checkSize();
        for(int i = size-1; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public void addLast(Object element){
        //O(1)
        checkSize();
        data[size] = element;
        size++;
    }

    public Object remove(int index){
        Object element = data[index];
        for(int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        checkSize();
        return element;
    }

    public Object get(int index){
        if(index < 0 || index >= size) return null;
        return data[index];
    }

    public Object set(Object element, int index){
        if (index < 0 || index >= data.length) return null;
        else{
            Object old = data[index];
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
}
