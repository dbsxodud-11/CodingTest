package Search;

import java.io.*;
import java.util.*;

public class Maximum_Subarray {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        
        //1. Greedy
        Map<Long, Integer> hashmap = new HashMap<>();
        for(int i=0; i<a.length; i++){
            hashmap.put(a[i], hashmap.getOrDefault(a[i], 0) + 1);
        }

        long answer = 0;
        for(int i=1; i<=a.length; i++){
            int index = 0;
            while(index + i <= a.length){
                long sum = 0;
                for(int k = index; k < index + i; k++){
                    sum += a[k];
                }
                if (answer < sum % m){
                    answer = sum % m;
                }
                index += Math.max(1, hashmap.get(a[index]) - i + 1);
                //System.out.println(sum);
                if (answer == m-1) return answer;
            }
        }
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
