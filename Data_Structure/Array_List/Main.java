package Data_Structure.Array_List;

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

        arraylist.addLast(11);
        System.out.println(arraylist.get(5));

        arraylist.remove(2);
        arraylist.remove(2);
        System.out.println(arraylist.get(2));
    }
}
