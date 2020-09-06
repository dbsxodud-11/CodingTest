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

        
        
        return 0;
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
