package Linked_List;

public class Main {

    public static void main(String[] args){
        //1. Singly Linked List
        SinglyLinkedList<Integer> linked_list = new SinglyLinkedList<>();

        //Insertion
        linked_list.addFirst(1);
        linked_list.addFirst(2);
        linked_list.addLast(3);
        linked_list.addLast(4);

        System.out.println(linked_list.peek());
        System.out.println(linked_list.bottom());

        //Deletion
        linked_list.removeFirst();
        linked_list.removeLast();

        System.out.println(linked_list.peek());
        System.out.println(linked_list.bottom());

        //Merge
        SinglyLinkedList<Integer> sub_linked_list = new SinglyLinkedList<>();
        
        sub_linked_list.addFirst(5);
        sub_linked_list.addFirst(6);
        sub_linked_list.addLast(7);
        sub_linked_list.addLast(8);

        linked_list.merge(sub_linked_list);

        System.out.println(linked_list.peek());
        System.out.println(linked_list.bottom());
        System.out.println(linked_list.size());

        //Contains
        System.out.println(linked_list.contains(5));
        System.out.println(linked_list.contains(4));

        //Reverse
        linked_list.reverse();
        System.out.println(linked_list.peek());
        System.out.println(linked_list.bottom());

        System.out.println("---------------------------------------------------------");

        //2. Doubly Linked List
        DoublyLinkedList<Integer> doubly_linked_list = new DoublyLinkedList<>();

        //Insertion
        doubly_linked_list.addFirst(1);
        doubly_linked_list.addFirst(2);
        doubly_linked_list.addLast(3);
        doubly_linked_list.addLast(4);

        System.out.println(doubly_linked_list.peek());
        System.out.println(doubly_linked_list.bottom());

        //Deletion
        doubly_linked_list.removeFirst();
        doubly_linked_list.removeLast();

        System.out.println(doubly_linked_list.peek());
        System.out.println(doubly_linked_list.bottom());

    }
}
