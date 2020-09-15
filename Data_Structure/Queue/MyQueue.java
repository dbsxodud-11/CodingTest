package Data_Structure.Queue;
import Data_Structure.Linked_List.SinglyLinkedList;

public class MyQueue<E> {
    
    private SinglyLinkedList<E> linked_list;

    public MyQueue(){
        linked_list = new SinglyLinkedList<>();
    }

    public void offer(E element){
        linked_list.addLast(element);
    }

    public E poll(){
        return linked_list.removeFirst();
    }

    public E peek(){
        return linked_list.peek();
    }

    public int size(){
        return linked_list.size();
    }

    public boolean isEmpty(){
        return linked_list.isEmpty();
    }

    public SinglyLinkedList<E> getLinkedList(){
        return linked_list;
    }

    public void merge(MyQueue<E> sub_queue){
        linked_list.merge(sub_queue.getLinkedList());
    }

    //O(n)
    public boolean contains(E element){
        return linked_list.contains(element);
    }
}
