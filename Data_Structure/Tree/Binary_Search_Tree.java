package Data_Structure.Tree;

import java.lang.Comparable;


public class Binary_Search_Tree<E extends Comparable<E>> {
    

    private static class Node<E>{
        
        private E element;
        private Node<E> left;
        private Node<E> right;
        private int n; //number of nodes in a subtree

        public Node(E element, int n){
            this.element = element;
            this.n = n;
        }   
    }

    private Node<E> root;

    public Binary_Search_Tree(){
        root = null;
    }

    public void insert(E element){
        root = insert(root, element);
    }

    private Node<E> insert(Node<E> x, E element){
        if(x == null) return new Node<E>(element, 1);
        else{
            int cmp = element.compareTo(x.element);
            if(cmp < 0) x.left = insert(x.left, element);
            else if(cmp > 0) x.right = insert(x.right, element);
            else{
                x.element = element;
            }
            x.n = 1 + getSize(x.left) + getSize(x.right);
            return x;
        }
    }

    public boolean search(E element){
        Node<E> temp = root;
        while(temp != null){
            int cmp = element.compareTo(temp.element);
            if(cmp < 0) temp = temp.left;
            else if(cmp > 0) temp = temp.right;
            else{
                return true;
            }
        }
        return false;
    }

    private int getSize(Node<E> x){
        if(x == null) return 0;
        return x.n;
    }

    public int size(){
        return root.n;
    }

    public boolean isEmpty(){
        return getSize(root) == 0;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node<E> x){
        if(x == null) return;
        else{
            inOrder(x.left);
            System.out.println(x.element);
            inOrder(x.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<E> x){
        if(x == null) return;
        else{
            System.out.println(x.element);
            preOrder(x.left);
            preOrder(x.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node<E> x){
        if(x == null) return;
        else{
            postOrder(x.left);
            postOrder(x.right);
            System.out.println(x.element);
        }
    }
}
