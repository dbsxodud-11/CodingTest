package Algorithms.Implementation;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class Climb_Leaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player){

        //1. Store ranked score in treemap
        Map<Integer, Integer> treemap = new TreeMap<>();
        int rank = 1;
        for(int score: ranked){
            if(treemap.containsKey(score)) continue;
            else{
                treemap.put(score, rank);
                rank++;
            }
        }

        //2. Find rank of player's score
        List<Integer> answer = new LinkedList<>();
        Iterator<Integer> iter_ranked = treemap.keySet().iterator();
        Iterator<Integer> iter_player = player.iterator();
        int ranked_score = -1;
        int player_score = -1;
        while(iter_player.hasNext()){
            player_score = iter_player.next();
            int size = answer.size();
            while(iter_ranked.hasNext()){
                if(ranked_score > player_score){
                    answer.add(treemap.get(ranked_score)+1);
                    break;
                }else if(ranked_score == player_score){
                    answer.add(treemap.get(ranked_score));
                    break;
                }else{
                    ranked_score = iter_ranked.next();                    
                }
            }
            if(size == answer.size()){
                if(ranked_score > player_score) answer.add(treemap.get(ranked_score)+1);
                else if(ranked_score == player_score) answer.add(treemap.get(ranked_score));
                else answer.add(1);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
