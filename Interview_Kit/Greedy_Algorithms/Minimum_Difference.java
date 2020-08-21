package Greedy_Algorithms;

import java.io.*;
import java.util.*;

public class Minimum_Difference {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        
        Arrays.sort(arr);
        int answer = 1000000000;
        for(int i=0; i<arr.length-1; i++){
            int candidates = Math.abs(arr[i] - arr[i+1]);
            if(candidates < answer) answer = candidates;
        }
        return answer;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = 3;//scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = {"3", "-1", "-4"};//scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.print(result);
        scanner.close();
    }
}
