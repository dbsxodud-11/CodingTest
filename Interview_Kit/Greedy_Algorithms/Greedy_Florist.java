package Greedy_Algorithms;

import java.io.*;
import java.util.*;

public class Greedy_Florist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int answer = 0;
        if(c.length <= k) {
            for(int price : c){
                answer += price;
            }
            return answer;
        }else{

            // Collections.sort(c, new Comparator<Integer>(){
            //     @Override
            //     public int compare(int o1, int o2){
            //         return o2.compareTo(o1);
            //     }
            // }); //오름차순
            Arrays.sort(c);
            int index = 0;
            while(index < k){
                answer += c[c.length - index - 1];
                index++;
                //System.out.println(answer);
            }
            while(index < c.length){
                answer += c[c.length - index - 1] * (index / k + 1);
                index++;
                //System.out.println(answer);
            }
            return answer;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        //bufferedWriter.write(String.valueOf(minimumCost));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(minimumCost);

        scanner.close();
    }
}
