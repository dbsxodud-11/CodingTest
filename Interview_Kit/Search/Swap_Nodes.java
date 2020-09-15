package Interview_Kit.Search;

import java.io.*;
import java.util.*;

public class Swap_Nodes {

    /*
     * Complete the swapNodes function below.
     */
    //Create a Node class
    static class Node{
        int value;
        int depth;
        Node left;
        Node right;

        public Node(int value, int depth, Node left, Node right){
            this.value = value;
            this.depth = depth;
            this.left = left;
            this.right = right;
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        //1. Create a Binary Tree
        Queue<Node> binary_tree = new LinkedList<>();
        Node root = new Node(1, 1, null, null);
        binary_tree.offer(root);
        int numberOfNodes = 0;
        int count = 1;
        while(numberOfNodes < indexes.length){
            Node parent = binary_tree.poll();
            int left_child = indexes[numberOfNodes][0];
            int right_child = indexes[numberOfNodes][1];

            parent.left = (left_child == -1)? null : new Node(left_child, parent.depth + 1, null, null);
            parent.right = (right_child == -1)? null : new Node(right_child, parent.depth + 1, null, null);

            if(parent.left != null && parent.left.value != -1) {
                binary_tree.offer(parent.left);
                count++;
            }
            if(parent.right != null && parent.right.value != -1) {
                binary_tree.offer(parent.right);
                count++;
            }
            numberOfNodes++;
        }
        //2. Swapping & Print
        int[][] answer = new int[queries.length][count];

        for(int i=0; i<queries.length; i++){
            swapping(root, 1, queries[i]);
            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            answer[i] = result.stream().mapToInt(x -> x).toArray(); //mapToInt: Integer -> int로 바꿔줌
        }

        return answer;
    }

    private static void swapping(Node root, int depth, int k){
        if(root == null) return;

        swapping(root.left, depth+1, k);
        swapping(root.right, depth+1, k);

        if(k <= depth && depth % k == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    private static void inOrder(Node root, List<Integer> result){
        if(root == null) return;

        inOrder(root.left, result);
        result.add(root.value);
        inOrder(root.right, result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                //bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
                System.out.print(result[resultRowItr][resultColumnItr]);
                if (resultColumnItr != result[resultRowItr].length - 1) {
                    //bufferedWriter.write(" ");
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                //bufferedWriter.write("\n");
                System.out.print("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
}
