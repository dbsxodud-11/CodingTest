package Data_Structure.Queue;

public class Main {
    
    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.poll();
        queue.poll();

        System.out.println(queue.peek());
        System.out.println(queue.size());

        MyQueue<Integer> sub_queue = new MyQueue<>();

        sub_queue.offer(5);
        sub_queue.offer(6);
        sub_queue.offer(7);
        sub_queue.poll();

        System.out.println(sub_queue.peek());
        System.out.println(sub_queue.size());

        queue.merge(sub_queue);

        System.out.println(queue.peek());
        System.out.println(queue.size());

        System.out.println(queue.contains(4));
        System.out.println(queue.contains(5));
    }
}
