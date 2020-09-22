package Algorithms.Implementation;

import java.io.*;
import java.util.Scanner;

public class Append_Delete{

    public static String appendAndDelete(String s, String t, int k){
        
        char[] s_split = s.toCharArray();
        char[] t_split = t.toCharArray();

        int index = 0;
        while(index < Math.min(s.length(), t.length()) && s_split[index] == t_split[index]){
            index++;
        }
        //Analyze cases
        if(k >= s.length() + t.length()) return "YES";
        if(index == 0){
            return (k >= (s.length() + t.length())) ? "Yes" : "No";
        }else if(index == s.length() && index == t.length()){
            return (k % 2 == 0 || k >= (s.length() + t.length())) ? "Yes" : "No";
        }else{
            return (k >= (s.length() - index + t.length() - index) && (k - (s.length() - index + t.length() - index)) % 2 == 0) ? "Yes" : "No";
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}