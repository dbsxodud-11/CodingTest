package Stacks_Queues;

import java.io.*;
import java.util.*;

public class Min_Max_Riddle {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function
        //find maximum window size
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        Stack<Integer> stack_left = new Stack<>();
        Stack<Integer> stack_right = new Stack<>();

        for(int i=0; i<arr.length; i++){
            //left
            if(stack_left.isEmpty()) {
                stack_left.push(i);
                left[i] = i;
            }else{
                while(!stack_left.isEmpty() && arr[i] <= arr[stack_left.peek()]){
                    stack_left.pop();
                }
                left[i] = i - (stack_left.isEmpty() ? 0 : stack_left.peek()+1);
                stack_left.push(i);
            }
            //right
            if(stack_right.isEmpty()){
                stack_right.push(i);
                right[arr.length-i-1] = i;
            }else{
                while(!stack_right.isEmpty() && arr[arr.length-i-1] <= arr[arr.length-stack_right.peek()-1]){
                    stack_right.pop();
                }
                right[arr.length-i-1] = i - (stack_right.isEmpty() ? 0 : stack_right.peek()+1);
                stack_right.push(i);
            }
        }
        // for(int i=0; i<arr.length; i++){
        //     System.out.println(left[i] + " " + right[i]);
        // }
        Map<Long, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], Math.max(map.getOrDefault(arr[i], -1), left[i]+right[i]+1));
        }
        // Map<Integer, Long> map = new HashMap<>();
        // for(int i=0; i<arr.length; i++){
        //     int index = left[i] + right[i] + 1;
        //     if(map.containsKey(index)){
        //         if(map.get(index) < arr[i]) map.put(index, arr[i]);
        //     }else{
        //         map.put(index, arr[i]);
        //     }
        // }
        for(long key: map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
        Iterator<Long> iter = map.keySet().iterator();
        long index = iter.next();
        long[] answer = new long[arr.length];
        for(int i=0; i<arr.length; i++){
            while(map.get(index) <= i){
                index = iter.next();
            }
            answer[i] = index;
        } 
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            //bufferedWriter.write(String.valueOf(res[i]));
            System.out.print(res[i] + "\t");
            if (i != res.length - 1) {
                //bufferedWriter.write(" ");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}

