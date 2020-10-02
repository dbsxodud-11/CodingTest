package Algorithms.Strings;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Steady_Gene {

    public static int steadyGene(String gene) {

        //1.Brute Force -> 2.Optimize
        Map<Character, Integer> hashmap = new HashMap<>();
        int[][] check = new int[gene.length()+1][4];
        check[0][0] = 0;
        check[0][1] = 0;
        check[0][2] = 0;
        check[0][3] = 0;

        for(int i=1; i<=gene.length(); i++){
            hashmap.put(gene.charAt(i-1), hashmap.getOrDefault(gene.charAt(i-1), -gene.length()/4)+1);
            check[i][0] = (gene.charAt(i-1) == 'A') ? check[Math.max(i-1, 0)][0]+1: check[Math.max(i-1, 0)][0];
            check[i][1] = (gene.charAt(i-1) == 'C') ? check[Math.max(i-1, 0)][1]+1: check[Math.max(i-1, 0)][1];
            check[i][2] = (gene.charAt(i-1) == 'G') ? check[Math.max(i-1, 0)][2]+1: check[Math.max(i-1, 0)][2];
            check[i][3] = (gene.charAt(i-1) == 'T') ? check[Math.max(i-1, 0)][3]+1: check[Math.max(i-1, 0)][3];
        }
        Map<Character, Integer> modify = new HashMap<>();
        for(char key: hashmap.keySet()){
            if(hashmap.get(key) > 0) {
                modify.put(key, hashmap.get(key));
            }
        }

        //modification not required
        if(modify.size() == 0) return 0;

        //find smallest length of substring should be modified
        //Optimize - Binary Search
        int lo = 1; int hi = gene.length();
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            System.out.print(mid);
            if(isPossible(mid, check, modify)) {
                hi = mid;
                if(lo >= hi) return mid;
            }else{
                lo = mid+1;
                if(lo >= hi) return mid+1;
            }
        }
        return gene.length();
    }

    private static boolean isPossible(int mid, int[][] check, Map<Character, Integer> modify){
        for(int i=0; i<check.length-mid; i++){
            if(check[i+mid][0] - check[i][0] < modify.getOrDefault('A', 0)) continue;
            if(check[i+mid][1] - check[i][1] < modify.getOrDefault('C', 0)) continue;
            if(check[i+mid][2] - check[i][2] < modify.getOrDefault('G', 0)) continue;
            if(check[i+mid][3] - check[i][3] < modify.getOrDefault('T', 0)) continue;
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }    
}
