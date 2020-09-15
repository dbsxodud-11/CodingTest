package Interview_Kit.Stacks_Queues;

//import java.io.*;
import java.util.*;

public class Queue_Basic_Methods {

    public static class MyQueue<E extends Comparable<E>>{

        private LinkedList<E> list;

        public MyQueue(){
            list = new LinkedList<E>();
        }

        public void enqueue(E element){
            list.add(element);
        }

        public E dequeue(){
            if(list.isEmpty()) return null;
            return list.removeFirst();
        }

        public E peek(){
            if(list.isEmpty()) return null;
            return list.get(0);
        }

        //isEmpty()
        public boolean isEmpty(){
            return list.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
