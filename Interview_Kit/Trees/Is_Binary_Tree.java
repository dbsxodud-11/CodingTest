package Interview_Kit.Trees;

import java.util.*;

public class Is_Binary_Tree {

    private static class Node {
        Node left;
        Node right;
        int data;
        
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static boolean check(Node root){
        return check(root, -1, 100001);
    }

    private static boolean check(Node x, int min, int max){
        if(x == null) return true;
        else{
            if(x.data <= min || x.data >= max) return false;
            return check(x.left, min, x.data) && check(x.right, x.data, max);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean ans = check(root);
        System.out.println(ans);
    }
}
