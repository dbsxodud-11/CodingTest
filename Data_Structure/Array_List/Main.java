package Data_Structure.Array_List;

import java.util.Iterator;

public class Main {
    
    public static void main(String[] args){
        
        //ArrayList
        MyArrayList<Integer> arraylist = new MyArrayList<>();
        
        arraylist.add(0, 1);
        arraylist.add(1, 3);
        arraylist.add(2, 5);
        arraylist.add(3, 9);
        arraylist.add(3, 7);

        System.out.println(arraylist.get(3));
        System.out.println(arraylist.get(4));
        System.out.println(arraylist.size());

        arraylist.remove(2);
        arraylist.remove(2);
        System.out.println(arraylist.get(2));

        arraylist.set(10, 2);
        System.out.println(arraylist.get(2));

        //Iterator
        Iterator<Integer> iter = arraylist.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + "\t");
        }
    }
}
