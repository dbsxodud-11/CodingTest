package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Candies {

    static long candies(int n, int[] arr){

        // long answer = 0;

        // LinkedList<Integer> list = new LinkedList<>();
        // int index = 0;
        // while(index+1 < n){
        //     boolean flag = arr[index] < arr[index+1];
        //     int number = 0;
        //     while(index+1 < n && flag == (arr[index] < arr[index+1])){
        //         index++;
        //         number++;
        //     }
        //     list.add(number);
        // }

        // boolean flag = arr[0] < arr[1];
        // answer += (list.getFirst() + 1)*(list.getFirst() + 2) / 2;
        // list.removeFirst(); //O(1)
        // flag = !flag;
        // for(int element : list){
        //     if(flag == true){
        //         answer += (element+1)*(element+2) / 2 - 1;
        //         flag = false;
        //     }else{
        //         answer += element * (element+1) / 2;
        //         flag = true;
        //     }
        //     //System.out.print(answer + "\t");
        // }
        // return answer;

        long[] low = new long[n];
        long[] high = new long[n];

        for(int i=0; i<n; i++){
            if(i == 0){
                low[0] = 1;
                high[n-1] = 1;
            }else{
                if(arr[i-1] < arr[i]) low[i] = low[i-1] + 1;
                else low[i] = 1;
                if(arr[n-i-1] > arr[n-i]) high[n-i-1] = high[n-i] + 1;
                else high[n-i-1] = 1;
            }
        }
        long answer = 0;
        for(int i=0; i<n; i++){
            answer += Math.max(low[i], high[i]);
        }

        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        System.out.println(result);
        //bufferedWriter.close();
        scanner.close();
    }

}