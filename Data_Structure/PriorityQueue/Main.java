package Data_Structure.PriorityQueue;

public class Main {
  
    public static void main(String[] args){
        //MaxPriorityQueue
        MaxPriorityQueue<Integer> max_pq = new MaxPriorityQueue<>();

        //Insertion
        max_pq.insert(14);
        max_pq.insert(45);
        max_pq.insert(75);
        max_pq.insert(53);
        max_pq.insert(42);
        max_pq.insert(37);
        max_pq.insert(28);

        System.out.println(max_pq.max());
        System.out.println(max_pq.size());

        //Deletion
        max_pq.delMax();
        max_pq.delMax();
        max_pq.delMax();

        System.out.println(max_pq.max());
        System.out.println(max_pq.size());
    }
}
