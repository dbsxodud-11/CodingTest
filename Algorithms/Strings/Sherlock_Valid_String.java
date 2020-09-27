package Algorithms.Strings;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Sherlock_Valid_String {
    
    public static String isValid(String s){

        //1. Brute Force
        Map<Character, Integer> hashmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0)+1);
        }

        int appear = -1;
        boolean first = true;
        for(char key: hashmap.keySet()){
            if(appear == -1) appear = hashmap.get(key);
            else{
                if(appear == hashmap.get(key)) continue;
                else {
                    first = false;
                    break;
                }
            }
        }
        if(first) return "YES"; //First Case
        else{
            boolean second = true;
            for(char key: hashmap.keySet()){
                int appear_minus = hashmap.get(key)-1;
                appear = -1;
                for(char other: hashmap.keySet()){
                    if(key == other) continue;
                    else{
                        if(appear_minus == 0){
                            if(appear == -1) appear = hashmap.get(other);
                            else {
                                if(hashmap.get(other) != appear){
                                    second = false;
                                    break;
                                }
                            }
                        }else{
                            if(hashmap.get(other) != appear_minus) {
                                second = false;
                                break;
                            }   
                        }
                    }
                }
                if(second) return "YES";
                second = true;
            }
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
