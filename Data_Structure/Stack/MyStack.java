package Data_Structure.Stack;
import Data_Structure.Linked_List.SinglyLinkedList;


public class MyStack<E> {
    
    private SinglyLinkedList<E> linked_list;

    public MyStack(){
        linked_list = new SinglyLinkedList<>();
    }

    public void push(E element){
        linked_list.addFirst(element);
    }

    public E pop(){
        return linked_list.removeFirst();
    }

    public E peek(){
        return linked_list.peek();
    }

    public int size(){
        return linked_list.size();
    }

    public boolean isEmpty(){
        return linked_list.size() == 0;
    }

    public boolean contains(E element){
        return linked_list.contains(element);
    }

    public SinglyLinkedList<E> getLinkedList(){
        return linked_list;
    }

    public void merge(MyStack<E> sub_stack){
        linked_list.merge(sub_stack.getLinkedList());
    }
}
