package Interview_Kit.Trees;

import java.util.*;
//import java.io.*;


class Lowest_Common_Ancestor {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
    */
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
    
	public static Node lca(Node root, int v1, int v2) {
          // Write your code here.
          Node ancestor = findAncestor(root, v1, v2);
          return ancestor;
    }

    private static Node findAncestor(Node x, int v1, int v2){

        if(x.data < v1 && x.data < v2){
            if(x.right.data == v1 || x.right.data == v2) return x.right;
            return findAncestor(x.right, v1, v2);
        }else if(x.data > v1 && x.data > v2){
            if(x.left.data == v1 || x.left.data == v2) return x.left;
            return findAncestor(x.left, v1, v2);
        }else{
            return x;
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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}