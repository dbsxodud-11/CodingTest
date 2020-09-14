package Linked_List;

public class SinglyLinkedList<E>{

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
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E element){
        Node<E> newNode = new Node<E>(element);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            Node<E> temp = head;
            head = newNode;
            head.next = temp;
        }
        size++;
    }

    public void addLast(E element){
        Node<E> newNode = new Node<E>(element);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        else{
            Node<E> oldHead = head;
            head = head.next;
            if(size == 1) tail = null;
            size--;
            return oldHead.getElement();
        }
    }

    public E removeLast(){
        if(isEmpty()) return null;
        else if(size == 1){
            Node<E> oldTail = tail;
            head = null;
            tail = null;
            size--;
            return oldTail.getElement();
        }
        else{
            Node<E> temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            Node<E> oldTail = temp.next;
            tail = temp;
            tail.next = null;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //Merge
    public void merge(SinglyLinkedList<E> merged){
        Node<E> first = merged.getFirst();
        tail.next = first;
        Node<E> second = merged.getLast();
        tail = second;
        size += merged.size();
    }

    //Contains - O(n)
    public boolean contains(E element){
        Node<E> temp = head;
        while(temp != null){
            if(temp.getElement().equals(element)) return true;
            temp = temp.next;
        }
        return false;
    }

    //Reverse - O(n)
    public void reverse(){
        if(size < 2) return;
        Node<E> prevNode = head;
        Node<E> nextNode = head.next;
        prevNode.next = null;
        while(nextNode != null){
            Node<E> temp = nextNode.next;
            nextNode.next = prevNode;
            prevNode = nextNode;
            nextNode = temp;
        }
        Node<E> oldHead = head;
        head = tail;
        tail = oldHead;
    }
}