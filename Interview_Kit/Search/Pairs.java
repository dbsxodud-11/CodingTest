package Search;

import java.io.*;
import java.util.*;

public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        int answer = 0;
        while(true){
            if(arr[j] - arr[i] > k) {
                if(j - i == 1) j++;
                if(j == arr.length) break; 
                i++;
            }else if(arr[j] - arr[i] == k){
                i++;
                if(j != arr.length - 1) j++;
                answer++;
                if(j == i) break;
            }else{
                if(j != arr.length - 1) j++;
                else break;
            }
        }
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        System.out.println(result);
        //bufferedWriter.close();

        scanner.close();
    }
}