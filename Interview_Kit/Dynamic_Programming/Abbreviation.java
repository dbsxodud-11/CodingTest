package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        boolean[][] answer = new boolean[a.length()][b.length()];
        for(int j=0; j<answer[0].length; j++){
            for(int i=0; i<answer.length; i++){
                if(i == 0 && j == 0){
                    answer[i][j] = isEqual(a.charAt(i), b.charAt(j));
                }else if(i == 0 && j != 0){
                    answer[i][j] = false;
                }else if(i != 0 && j == 0){
                    answer[i][j] = isEqual(a.charAt(i), b.charAt(j));
                    if(answer[i-1][j] && Character.isLowerCase(a.charAt(i))) answer[i][j] = true;
                }else{
                    answer[i][j] = answer[i-1][j-1] && isEqual(a.charAt(i), b.charAt(j));
                    if(Character.isLowerCase(a.charAt(i)) && answer[i-1][j]){
                        answer[i][j] = true;
                    }
                }
                //System.out.print(answer[i][j] + "\t");
            }
            //System.out.println();
        }
        return answer[a.length()-1][b.length()-1] ?  "YES" : "NO"; 
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