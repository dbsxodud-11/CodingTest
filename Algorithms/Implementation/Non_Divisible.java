package Algorithms.Implementation;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Non_Divisible {
    
    public static int nonDivisibleSubset(int k, List<Integer> s){
        
        // //1. calculate sum of two elements
        // boolean[][] possible = new boolean[s.size()][s.size()];
        // for(int i=0; i<s.size(); i++){
        //     for(int j=i+1; j<s.size(); j++){
        //         if((s.get(i) + s.get(j)) % 4 != 0){
        //             possible[i][j] = true;
        //             possible[j][i] = true;
        //         }
        //     }
        // }
        // Set<Integer> set = new HashSet<>();
        // for(int i=0; i<s.size(); i++){
        //     set.add(i);
        // }
        // //2. Find a maximum subset
        // Queue<Set<Integer>> queue = new LinkedList<>();
        // queue.offer(set);
        // while(!queue.isEmpty()){
        //     Set<Integer> subset = queue.poll();
        //     if(isDivisible(subset, possible)) return subset.size();
        //     else{
        //         for(int element: subset){
        //             Set<Integer> newSet = new HashSet<>(subset);
        //             newSet.remove(element);
        //             queue.offer(newSet);
        //         }
        //     }
        // }
        // return 0;

        //Discussions: use remainder
        int[] remainders = new int[k];
        for(int element: s){
            remainders[element % k]++;
        }
        int count = 0;
        if(remainders[0] > 0) count++;
        if(k % 2 == 0){
            for(int i=1; i<k/2; i++){
                count += Math.max(remainders[i], remainders[k-i]);
            }
            if(remainders[k/2] > 0) count++;
        }else{
            for(int i=1; i<(k+1)/2; i++){
                count += Math.max(remainders[i], remainders[k-i]);
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
