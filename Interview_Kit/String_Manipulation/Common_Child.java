package String_Manipulation;

import java.io.*;
import java.util.*;

public class Common_Child {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        String[] s1_split = s1.split("");
        String[] s2_split = s2.split("");

        int[][] answer = new int[s1.length()][s2.length()];
        for (int i=0; i<s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                
                if(s1_split[i].equals(s2_split[j])){
                    if (i==0 || j==0) answer[i][j] += 1;
                    else answer[i][j] = answer[i-1][j-1] + 1;
                }else{
                    if (i==0 && j != 0) answer[i][j] = answer[i][j-1];
                    else if (i != 0 && j==0) answer[i][j] = answer[i-1][j];
                    else if (i==0 && j==0) answer[i][j] = 0; 
                    else answer[i][j] = Math.max(answer[i-1][j], answer[i][j-1]);
                }
            }
        }
        return answer[s1.length()-1][s2.length()-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = "SHINCHAN";//scanner.nextLine();

        String s2 = "NOHARAAA";//scanner.nextLine();

        int result = commonChild(s1, s2);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}