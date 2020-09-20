package Data_Structure.PriorityQueue;

public class Main {
  
    public static void main(String[] args){
        //MaxPriorityQueue
        System.out.println("----------------Max Priority Queue----------------------");
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

        System.out.println("----------------Min Priority Queue----------------------");
        MinPriorityQueue<Integer> min_pq = new MinPriorityQueue<>();

        //Insertion
        min_pq.insert(14);
        min_pq.insert(45);
        min_pq.insert(75);
        min_pq.insert(53);
        min_pq.insert(42);
        min_pq.insert(37);
        min_pq.insert(28);

        System.out.println(min_pq.min());
        System.out.println(min_pq.size());

        //Deletion
        min_pq.delMin();
        min_pq.delMin();
        min_pq.delMin();

        System.out.println(min_pq.min());
        System.out.println(min_pq.size());
    }
}
