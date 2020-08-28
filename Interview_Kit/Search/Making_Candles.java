package Search;

import java.io.*;
import java.util.*;

public class Making_Candles {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {

        //Use BinarySearch
        long production = 0;
        long answer = 0;
        while(production < n){
            answer += 1;
            production += m*w;
            System.out.print(m);
            System.out.print(w);
            System.out.println(production);
            if(production >= n) break;
            long[] action = findAction(m, w, p, production);
            //System.out.print(action[0] + '\t');
            //System.out.print(action[1] + '\n');
            production = production - p * (action[0] + action[1]);
            m += action[0];
            w += action[1];
        }

        return answer;
    }

    private static long[] findAction(long m, long w, long p, long production){
        long[] action = new long[2];
        long max = 0;

        for(int i=0; i<=production/p; i++){

            long candidates = (m + i - p >= 0) ? (m + i) * (w + (production - i*p)/p) - p * (i + (production - i*p)/p) : (m + i) * w - i*p;

            if(max < candidates){
                max = candidates;
                action[0] = i;
                action[1] = (m + i -p >= 0) ? (production - i*p)/p : 0;
            }
        }

        return action;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}
