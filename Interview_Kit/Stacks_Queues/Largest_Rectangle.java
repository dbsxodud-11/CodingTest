package Stacks_Queues;

import java.io.*;
import java.util.*;

public class Largest_Rectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

        long max = 0;
            
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index < h.length){
            if(stack.isEmpty() || h[index] > h[stack.peek()]){
                stack.push(index);
                index++;
            }else{
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                long candidates = (long)(height * width);
                max = candidates > max ? candidates : max;
            }
        }

        while(!stack.isEmpty()){
            int height = h[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;
            long candidates = (long)(height * width);
            max = candidates > max ? candidates : max;
        }
        
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}