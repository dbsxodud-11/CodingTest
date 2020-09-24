package Algorithms.Strings;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Strong_Password {
    
    public static int minimumNumber(int n, String password){

        String special_characters = "!@#$%^&*()-+";
        //Store condition
        Map<String, Integer> hashmap = new HashMap<>();
        for(int i=0; i<n; i++){
            if(Character.isDigit(password.charAt(i))) hashmap.put("Digit", 1);
            else if(Character.isLowerCase(password.charAt(i))) hashmap.put("LowerCase", 1);
            else if(Character.isUpperCase(password.charAt(i))) hashmap.put("UpperCase", 1);
            else{
                for(int j=0; j<special_characters.length(); j++){
                    if(special_characters.charAt(j) == password.charAt(i)) {
                        hashmap.put("Speical", 1);
                        break;
                    }
                }
            }
        }

        if(n >= 6){
            return 4 - hashmap.size();
        }else{
            return Math.max(4 - hashmap.size(), 6 - n);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
