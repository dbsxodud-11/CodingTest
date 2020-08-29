package Search;

import java.io.*;
import java.util.*;

public class Making_Candles {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {

        //1. Greedy
        // long production = 0;
        // long answer = 0;
        // while(production < n){
        //     answer += 1;
        //     production += m*w;
        //     System.out.print(m);
        //     System.out.print(w);
        //     System.out.println(production);
        //     if(production >= n) break;
        //     long[] action = findAction(m, w, p, production);
        //     //System.out.print(action[0] + '\t');
        //     //System.out.print(action[1] + '\n');
        //     production = production - p * (action[0] + action[1]);
        //     m += action[0];
        //     w += action[1];
        // }

        // return answer;

        //2. Optimal
        // long production = 0;
        // long answer = 0;

        // while(production < n){
        //     answer+= 1;
        //     production += m*w;
        //     if(production >= n) break;

        //     long passes = (p - production) / (m*w);
        //     if(passes <= 0){
        //         long invest = production / p + m + w;
        //         long half = (long)Math.ceil(invest/2);
        //         if(m > w){
        //             m = Math.max(m, half);
        //             w = invest -m;
        //         }else{
        //             w = Math.max(m, half);
        //             m = invest - m;
        //         }
        //         production %= p;
        //     }
        // }

        // return answer;

        //3. Binary Search(Editorial)
        long lo = 1;
        long hi = (long)Math.pow(10,12); //최소와 최대가 정해져 있음 - binary search!!
        long mid = 0;

        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            
            if(check(m, w, p, n, mid)){
                hi = mid;
                if(lo >= hi) return mid;
            }else{
                lo = mid+1;
                if(lo >= hi) return mid+1;
            }
        }

        return mid;
    }

    // private static long[] findAction(long m, long w, long p, long production){
    //     long[] action = new long[2];
    //     long max = 0;

    //     for(int i=0; i<=production/p; i++){

    //         long candidates = (m + i - p >= 0) ? (m + i) * (w + (production - i*p)/p) - p * (i + (production - i*p)/p) : (m + i) * w - i*p;

    //         if(max < candidates){
    //             max = candidates;
    //             action[0] = i;
    //             action[1] = (m + i -p >= 0) ? (production - i*p)/p : 0;
    //         }
    //     }

    //     return action;
    // }

    private static boolean check(long m, long w, long p, long n, long mid){
        
        if (m >= (n+w-1)/w) return true;
        long current = m*w;
        mid--;
        if(mid == 0) return false;

        while(true){
            long remain = n - current;
            long remainPass = (remain + m*w - 1) / (m*w);
            if(remainPass <= mid) return true;

            if(current < p){
                remain = p - current;
                remainPass = (remain + m*w - 1) / (m*w);
                mid -= remainPass;
                if(mid <= 0) return false;
                current += remainPass*m*w;

            }
            current -= p;
            if(m > w){
                w++;
            }else{
                m++;
            }
        }
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
