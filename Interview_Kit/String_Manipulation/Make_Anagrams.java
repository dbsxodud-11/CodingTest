package Interview_Kit.String_Manipulation;

import java.io.*;
import java.util.*;

public class Make_Anagrams {

    // Complete the makeAnagram function below.
    static int Solution(final String a, final String b) {
       final Map<String, Integer> hashmap = new HashMap<>();
       
       final String[] a_split = a.split("");
       final String[] b_split = b.split("");

       for (final String s: a_split){
           hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
       }
       int answer = 0;
       for (final String s: b_split){
           if(hashmap.containsKey(s)){
               hashmap.put(s, hashmap.get(s)-1);
               if (hashmap.get(s) == 0) hashmap.remove(s);
           }else{
               answer++;
           }
       }

       for (final String key: hashmap.keySet()){
           answer += hashmap.get(key);
       }

       return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) throws IOException {
        //final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final String a = "abc";//scanner.nextLine();

        final String b = "dbf";//scanner.nextLine();

        final int res = Solution(a, b);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
        System.out.print(res);
    }
}
