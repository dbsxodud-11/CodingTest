package Data_Structure.Tree;

public class Main {
    
    public static void main(String[] args){

        //Binary Search Tree Implementation
        Binary_Search_Tree<Integer> binary_search_tree = new Binary_Search_Tree<>();

        //1. Insertion and Search - O(logn)
        binary_search_tree.insert(45);
        binary_search_tree.insert(15);
        binary_search_tree.insert(87);
        binary_search_tree.insert(24);
        binary_search_tree.insert(27);
        binary_search_tree.insert(63);
        binary_search_tree.insert(33);
        binary_search_tree.insert(72);

        System.out.println(binary_search_tree.search(14));
        System.out.println(binary_search_tree.search(27));
        System.out.println(binary_search_tree.isEmpty());
        
        //2. Tree Traversal
        System.out.println("----------Inorder traversal-------------------");
        binary_search_tree.inOrder();

        System.out.println("----------Preorder traversal------------------");
        binary_search_tree.preOrder();

        System.out.println("----------Postorder traversal-----------------");
        binary_search_tree.postOrder();
    }
}
