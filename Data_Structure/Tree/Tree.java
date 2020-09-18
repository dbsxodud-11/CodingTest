package Data_Structure.Tree;

public interface Tree<E>{

    //return true if the element is in the tree
    public boolean search(E element);

    //insert an element into the tree
    public void insert(E element);

    //remove an element from the tree
    public void remove(E element);

    //inorder traversal
    public void inOrder();

    //preorder traversal
    public void preOrder();

    //postorder traversal
    public void postOrder();

    //return size of the tree
    public int size();

    //return true if tree is empty
    public boolean isEmpty();
}
