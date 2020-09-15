package Interview_Kit.Greedy_Algorithms;

import java.io.*;
import java.util.*;

public class Luck_Balance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        List<Integer> important = new ArrayList<>();
        int answer = 0;
        for(int i=0; i<contests.length; i++){
            if(contests[i][1] == 1) important.add(contests[i][0]);
            else answer += contests[i][0];
        }
        Collections.sort(important);
        //System.out.println(important.size());
        for(int i=0; i<important.size(); i++){
            if (i < important.size() - k) answer -= important.get(i);
            else answer += important.get(i);
        }

        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.print(result);
        scanner.close();
    }
}