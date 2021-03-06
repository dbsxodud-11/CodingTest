package Algorithms.Strings;

import java.io.*;
import java.util.Scanner;

public class CamelCase {
    
    static int camelcase(String s) {

        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))) count++;
        }
        return count+1;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
