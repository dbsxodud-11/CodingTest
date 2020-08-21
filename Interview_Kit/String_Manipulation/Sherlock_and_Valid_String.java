package String_Manipulation;

import java.io.*;
import java.util.*;

public class Sherlock_and_Valid_String {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<String, Integer> hashmap1 = new HashMap<>();
        Map<Integer, Integer> hashmap2 = new HashMap<>();

        String[] s_split = s.split("");
        for (String key : s_split){
            hashmap1.put(key, hashmap1.getOrDefault(key, 0)+1);
            int value = hashmap1.get(key);
            if(value == 1){
                hashmap2.put(value, hashmap2.getOrDefault(value, 0)+1);
            }else{
                hashmap2.put(value, hashmap2.getOrDefault(value, 0)+1);
                hashmap2.put(value-1, hashmap2.get(value-1)-1);
                if (hashmap2.get(value-1) == 0) hashmap2.remove(value-1);
            }
        }

        if(hashmap2.size() == 1) return "YES";
        else if(hashmap2.size() == 2){
            List<Integer> keyset = new ArrayList<>();
            for(int key: hashmap2.keySet()){
                keyset.add(key);
            }
            Collections.sort(keyset);
            if(keyset.get(1) - keyset.get(0) == 1 && hashmap2.get(keyset.get(1)) == 1) return "YES";
            //등장 횟수가 1인 char가 하나 있는 상황도 가능
            if(keyset.get(0) == 1 && hashmap2.get(keyset.get(0)) == 1) return "YES";
        }
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "abbbccc";//scanner.nextLine();

        String result = isValid(s);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}
