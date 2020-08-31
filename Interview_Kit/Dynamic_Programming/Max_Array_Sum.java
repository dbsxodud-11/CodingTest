package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Max_Array_Sum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

        int max = 0;
        int[] result = new int[arr.length+1];

        result[0] = 0;
        if(arr.length >= 3) {
            result[1] = arr[0];
            result[2] = arr[1]; 
            
            for(int i=3; i<=arr.length; i++){
                if(arr[i-1] < 0){
                    result[i] = Math.max(result[i-3], result[i-2]);
                }else{
                    result[i] = Math.max(arr[i-1] + result[i-3], arr[i-1] + result[i-2]);
                }
                //System.out.println(result[i]);
                max = (max < result[i]) ? result[i] : max;
            }
        }else{
            return arr[0] + arr[1];
        }
        return max;
    }  

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(res);

        scanner.close();
    }
}