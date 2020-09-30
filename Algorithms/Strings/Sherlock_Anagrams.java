package Algorithms.Strings;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class Sherlock_Anagrams {

    public static int sherlockAndAnagrams(String s){

        int count = 0;
        //|s'| = 1, ... n-1까지 전부 탐색
        for(int i=1; i< s.length(); i++){
            //find anagrams
            Map<Map<Character, Integer>, Integer> list = new HashMap<>();
            for(int j=0; j<=s.length()-i; j++){
                Map<Character, Integer> hashmap = new HashMap<>();
                for(int k=0; k<i; k++){
                    hashmap.put(s.charAt(j+k), hashmap.getOrDefault(s.charAt(j+k), 0)+1);
                }
                boolean flag = false;
                if(list.isEmpty()) list.put(hashmap, 1);
                else{
                    for(Map<Character, Integer> map: list.keySet()){
                        if(isEqual(map, hashmap)){
                            list.put(map, list.getOrDefault(map, 0)+1);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) list.put(hashmap, 1);
                }
            }

            for(Map<Character, Integer> map: list.keySet()){
                //System.out.println(list.get(map));
                if(list.get(map) == 1) continue;
                else count += list.get(map)*(list.get(map)-1)/2;
            }
            //System.out.println();
        }
        return count;
    }

    private static boolean isEqual(Map<Character, Integer> hashmap1, Map<Character, Integer> hashmap2){
        for(char key: hashmap1.keySet()){
            if (!hashmap2.containsKey(key)) return false;
            else{
                if(hashmap1.get(key) != hashmap2.get(key)) return false;
            }
        }
        return true;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
