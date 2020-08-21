package String_Manipulation;

import java.io.*;
import java.util.*;

public class Alternating_Characters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int answer = 0;
        for (int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)) answer++;
        }

        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = 1;//scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = "AAABB";//scanner.nextLine();

            int result = alternatingCharacters(s);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
            System.out.println(result);
        }

        //bufferedWriter.close();
        scanner.close();
    }
}
