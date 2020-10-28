package Algorithms.Sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Counting_Sort {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {

        // //1. Count occurence
        // int[] ranking = new int[arr.size()];
        // String[] words = new String[arr.size()];
        // int index = 0;
        // int max = 0;
        // Map<Integer, Integer> treemap = new HashMap<>();
        // for(List<String> list : arr){
        //     int rank = Integer.parseInt(list.get(0));
        //     max = (rank > max) ? rank : max;
        //     ranking[index] = rank;
        //     words[index] = list.get(1);
        //     treemap.put(rank, treemap.getOrDefault(rank, 0)+1);
        //     index++;
        // }
        // int before = 0;
        // for(int i=0; i<=max; i++){
        //     if(treemap.containsKey(i)){
        //         treemap.put(i, treemap.get(i) + before);
        //         before = treemap.get(i);
        //     }
        // }

        // // for(int rank : treemap.keySet()){
        // //     System.out.println(treemap.get(rank));
        // // }

        // //2. Counting Sort
        // String[] result = new String[arr.size()];
        // int half = arr.size()/2;
        // for(int i=arr.size()-1; i>=0; i--){
        //     int position = treemap.get(ranking[i]);
        //     treemap.put(ranking[i], position-1);
        //     if(i < half){
        //         result[position-1] = "-";
        //     }else{
        //         result[position-1] = words[i];
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // for(String element : result){
        //     sb.append(element);
        //     sb.append("-");
        // }
        // System.out.print(sb.toString());

        //Second Method : Use StringBuilder Intensively
        Map<Integer, List<StringBuilder>> treemap = new TreeMap<>();
        int index = 0;
        int half = arr.size()/2;
        for(List<String> list : arr){
            int rank = Integer.parseInt(list.get(0));
            StringBuilder sb = new StringBuilder(list.get(1));
            if (index < half) sb = new StringBuilder("-");
            if(treemap.containsKey(rank)){
                treemap.get(rank).add(sb);
            }else{
                List<StringBuilder> rank_list = new LinkedList<>();
                rank_list.add(sb);
                treemap.put(rank, rank_list);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int key : treemap.keySet()){
            for(StringBuilder word : treemap.get(key)) {
                result.append(word);
                result.append(" ");
            }
        }

        System.out.print(result.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr);

        bufferedReader.close();
    }
}