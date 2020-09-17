package Interview_Kit.Recursion;

import java.io.*;
import java.util.*;

public class Digital_Sum {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {

        if(n.length() == 1) return calculate(Integer.toString(Integer.parseInt(n)*k));
        else{
            int start = 0;
            for(int i=0; i<n.length(); i++){
                start += Integer.parseInt(Character.toString(n.charAt(i)));
            }
            return superDigit(Integer.toString(start), k);
        }
    }

    private static int calculate(String s){
        if(s.length() == 1) return Integer.parseInt(s);
        else{
            int start = 0;
            for(int i=0; i<s.length(); i++){
                start += Integer.parseInt(Character.toString(s.charAt(i)));
            }
            return calculate(Integer.toString(start));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}

