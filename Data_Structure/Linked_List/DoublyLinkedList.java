package Linked_List;

public class DoublyLinkedList<E> {
    
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element){
            this.element = element;
            this.prev = null;
            this.next = null;
        }

        public E getElement(){
            return element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E element){
        Node<E> newHead = new Node<E>(element);
        if(head == null){
            head = newHead;
            tail = newHead;
        }else{
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
        size++;
    }

    public void addLast(E element){
        Node<E> newTail = new Node<E>(element);
        if(tail == null){
            head = newTail;
            tail = newTail;
        }else{
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        else if(size == 1){
            Node<E> oldHead = head;
            head = null;
            tail = null;
            size--;
            return oldHead.getElement();
        }else{
            Node<E> oldHead = head;
            head = head.next;
            head.prev = null;
            oldHead.next = null;
            size--;
            return oldHead.getElement();
        }
    }

    public E removeLast(){
        if(isEmpty()) return null;
        else if(size == 1){
            Node<E> oldTail =tail;
            head = null;
            tail = null;
            return oldTail.getElement();
        }else{
            Node<E> oldTail = tail;
            tail = tail.prev;
            tail.next = null;
            oldTail.prev = null;
            size--;
            return oldTail.getElement();
        }
    }

    public E peek(){
        return head.getElement();
    }

    public E bottom(){
        return tail.getElement();
    }

    public Node<E> getFirst(){
        return head;
    }

    public Node<E> getLast(){
        return tail;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
