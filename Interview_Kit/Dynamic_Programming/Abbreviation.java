package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        // char[] a_list = a.toCharArray();
        // char[] b_list = b.toCharArray();

        // int i = 0;
        // int j = 0;
        // while(i < a_list.length){
        //     //System.out.print(a_list[i] + "\t");
        //     //System.out.println(b_list[j]);
        //     if(j < b_list.length){
        //         if(a_list[i] == b_list[j]){
        //             i++;
        //             j++;
        //         }else if(Character.isLowerCase(a_list[i])){
        //             if(Character.toUpperCase(a_list[i]) == b_list[j]){
        //                 if(i+1 < a_list.length && j+1 < b_list.length && Character.toUpperCase(a_list[i+1]) == b_list[j] && Character.toUpperCase(a_list[i+1]) != b_list[j+1]){
        //                     i++;
        //                 }else{
        //                     i++;
        //                     j++;
        //                 }
        //             }else{
        //                 i++;
        //             }
        //         }else{
        //             return "NO";
        //         }
        //     }else{
        //         if(Character.isUpperCase(a_list[i])) return "NO";
        //         i++;
        //     }
        // }
        // if(j == b_list.length) return "YES";
        // return "NO";

        //2. Divide and Conquer
        boolean[][] dp = new boolean[a.length()][b.length()];

        for(int i=0; i<a.length(); i++){
            for(int j=0; j<b.length(); j++){

                if(j == 0){
                    dp[i][j] = isEqual(a.charAt(i), b.charAt(j));
                }else{
                    if(i > 0 && dp[i-1][j-1] && isEqual(a.charAt(i), b.charAt(j))) {
                        dp[i][j] = true;
                    }
                    
                }
                if(i > 0 && dp[i-1][j] && Character.isLowerCase(a.charAt(i))) dp[i][j] = true;                  
            }
        }
        return dp[a.length()-1][b.length()-1] ? "YES" : "NO";
    }

    private static boolean isEqual(char a, char b){
            return a == b || Character.toUpperCase(a) == b;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
            System.out.println(result);
        }

        //bufferedWriter.close();

        scanner.close();
    }
}