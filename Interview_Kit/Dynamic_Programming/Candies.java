package Interview_Kit.Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Candies {

    static long candies(int n, int[] arr){

        long answer = 0;
        
        long[] low = new long[arr.length];
        long[] high = new long[arr.length];

        for(int i=0; i<arr.length; i++){
            if(i == 0){
                low[0] = 1;
                high[n-1] = 1;
            }else{
                if(arr[i-1] < arr[i]) low[i] = low[i-1] + 1;
                else low[i] = 1;
                if(arr[n-i] < arr[n-i-1]) high[n-i-1] = high[n-i] + 1;
                else high[n-i-1] = 1;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            answer += (long)Math.max(low[i], high[i]);
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