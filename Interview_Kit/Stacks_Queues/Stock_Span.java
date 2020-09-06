package Stacks_Queues;

import java.io.*;
import java.util.*;

public class Stock_Span {

    public static int[] stockSpan(long[] arr){

        int[] indices = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                indices[i] = i+1;
            }else{
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                    stack.pop();
                }
                indices[i] = i - (stack.isEmpty() ? 0 : stack.peek()+1) + 1;
                stack.push(i);
            }
        }
        return indices;
    }
 
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i=0; i<n; i++){
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = stockSpan(arr);

        for(int i=0; i<n; i++){
            System.out.print(result[i] + "\t");
        }
    }
}
