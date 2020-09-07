package Stacks_Queues;

import java.io.*;
import java.util.*;

public class Posionous_Plants {

    public static class MyStack<E>{

        private static class Node<E>{
            private E element;
            private Node<E> next;

            public Node(E element){
                this.element = element;
                this.next = null;
            }

            public E getElement(){
                return element;
            }
            
            public Node<E> getNext(){
                return next;
            }
        }

        private Node<E> top;
        private Node<E> bottom;
        private int size;

        public MyStack(){
            this.top = null;
            this.bottom = null;
            this.size = 0;
        }

        public void push(E element){
            Node<E> node = new Node<E>(element);
            node.next = top;
            top = node;
            if(bottom == null) bottom = node;
            size++;
        }

        public E pop(){
            if(isEmpty()) return null;
            E answer = top.getElement();
            top = top.getNext();
            size--;
            if(size == 1) bottom = top;

            return answer;
        }
        public E peek() {return top.getElement();}
        public E ground() {return bottom.getElement();}

        public Node<E> getFirst() {return top;}
        public Node<E> getLast() {return bottom;}

        public void merge(MyStack<E> add_stack){
            Node<E> last = bottom;
            Node<E> first = add_stack.getFirst();
            last.next = first;
            bottom = add_stack.getLast();
            size += add_stack.size();
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int size() {return size;}
    }

    public static class MyQueue<E>{

        private static class Node<E>{

            private E element;
            private Node<E> next;

            public Node(E element){
                this.element = element;
                this.next = null;
            }

            public E getElement() {return element;}
            public Node<E> getNext() {return next;}
        }

        private Node<E> top;
        private Node<E> bottom;
        private int size;

        public MyQueue(){
            top = null;
            bottom = null;
            size = 0;
        }

        public void offer(E element){
            Node<E> node = new Node<E>(element);
            if(bottom == null) {
                bottom = node;
                top = node;
            }else{
               bottom.next = node;
            node.next = null;
            bottom = node; 
            }
            size++;
        }

        public E poll(){
            if(isEmpty()) return null;
            Node<E> newtop = top.getNext();
            E answer = top.getElement();
            top = newtop;
            size--;
            if(size == 1) bottom = top;
            return answer;
        }

        public E peek() {return top.getElement();}
        public E ground() {return bottom.getElement();}

        public Node<E> getFirst() {return top;}
        public Node<E> getLast() {return bottom;}

        public void merge(MyQueue<E> add_queue){
            Node<E> last = bottom;
            Node<E> first = add_queue.getFirst();

            last.next = first;
            bottom = add_queue.getLast();
            size += add_queue.size();
            add_queue.merged();
        }

        public void clear(){
            top = null;
            bottom = null;
            size = 0;
        }

        public boolean isEmpty() {return size == 0;}
        
        public int size() {return size;}
        public void merged() {size = 0;}
    }
    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {

        // //Stack Implementation
        // MyStack<Integer> stack = new MyStack<>();
        // stack.push(1);
        // stack.push(4);
        // stack.push(7);
        // stack.push(10);
        // stack.pop();
        // stack.pop();
        // System.out.println(stack.peek());
        // System.out.println(stack.ground());
        // System.out.println(stack.size());
        // System.out.println(stack.isEmpty());

        // MyStack<Integer> substack = new MyStack<>();
        // substack.push(3);
        // substack.push(5);
        // substack.push(7);

        // stack.merge(substack);
        // System.out.println(stack.peek());
        // System.out.println(stack.ground());
        // System.out.println(stack.size());
        // System.out.println(stack.isEmpty());

        //Queue Implementation
        // MyQueue<Integer> queue = new MyQueue<>();
        // queue.offer(1);
        // queue.offer(4);
        // queue.offer(7);
        // queue.offer(10);
        // queue.poll();
        // queue.poll();
        // System.out.println(queue.peek());
        // System.out.println(queue.ground());
        // System.out.println(queue.size());
        // System.out.println(queue.isEmpty());

        // MyQueue<Integer> subqueue = new MyQueue<Integer>();
        // subqueue.offer(3);
        // subqueue.offer(5);
        // subqueue.offer(7);

        // queue.merge(subqueue);
        // System.out.println(queue.peek());
        // System.out.println(queue.ground());
        // System.out.println(queue.size());
        // System.out.println(queue.isEmpty());

        LinkedList<MyQueue<Integer>> queue_list = new LinkedList<>();
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(p[0]);
        for(int i=1; i<p.length; i++){
            if(queue.ground() < p[i]){
                queue_list.add(queue);
                MyQueue<Integer> next_queue = new MyQueue<>();
                next_queue.offer(p[i]);
                queue = next_queue;
            }else{
                queue.offer(p[i]);
            }
        }
        queue_list.add(queue);
        int answer = 0;
        int count = 0;
        while(count + queue_list.getFirst().size() < p.length){
            answer++;
            //1. poll element at top(except the first one)
            Iterator<MyQueue<Integer>> iter_1 = queue_list.iterator();
            iter_1.next();
            while(iter_1.hasNext()){
                MyQueue<Integer> element_1 = iter_1.next();
                //System.out.println(element_1.peek());
                if(!element_1.isEmpty()) {
                    element_1.poll();
                    count++;
                }
            }

            //2. Merge if possible
            Iterator<MyQueue<Integer>> iter_2 = queue_list.iterator();
            MyQueue<Integer> queue_left = iter_2.next();
            int last = queue_left.ground();
            while(iter_2.hasNext()){
                MyQueue<Integer> queue_right = iter_2.next();
                if(queue_right.isEmpty()) continue;
                else{                    
                    if(queue_right.peek() <= last){
                        queue_left.merge(queue_right);
                        last = queue_right.ground();
                    }else{
                        queue_left = queue_right;
                        last = queue_left.ground();
                    }
                }
            }
        }
        
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        System.out.println(result);
        //bufferedWriter.close();

        scanner.close();
    }
}
