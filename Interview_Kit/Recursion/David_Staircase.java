package Interview_Kit.Recursion;

import java.io.*;
import java.util.*;

public class David_Staircase{

    // Complete the stepPerms function below.
    // 1. Recursive Helper Method
    // static int stepPerms(int n) {

    //     if(n == 1) return 1;
    //     else if(n == 2) return 2;
    //     else return (int)((stepPerms(n, 1) + stepPerms(n, 2) + stepPerms(n, 3))%10000000007L);
    // }

    // private static long stepPerms(int n, int position){
    //     if(position >= n) return 1;
    //     if(position+1 == n) return stepPerms(n, position+1);
    //     else if(position+2 == n) return stepPerms(n, position+1) + stepPerms(n, position+2);
    //     else return stepPerms(n, position+1) + stepPerms(n, position+2) + stepPerms(n, position+3);
    // }
    static int stepPerms(int n){
        int[] steps = new int[n];
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 4;
        else{
            steps[0] = 1;
            steps[1] = 2;
            steps[2] = 4;
            for(int i=3; i<n; i++){
                steps[i] = steps[i-1] + steps[i-2] + steps[i-3];
            }
            return steps[n-1];
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);
            System.out.println(res);
            //bufferedWriter.write(String.valueOf(res));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}