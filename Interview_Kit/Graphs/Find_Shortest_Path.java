package Interview_Kit.Graphs;

//import java.io.*;
import java.util.*;

public class Find_Shortest_Path {

    public static List<List<Integer>> graph;

    public static class Node{
        private int index;
        private int count;

        public Node(int index, int count){
            this.index = index;
            this.count = count;
        }

        public int getCount(){
            return count;
        }

        public int getIndex(){
            return index;
        }
    }

    public static int[] findShortest(int numberOfNodes, int[][] edges, int start){

        //1. construct graph
        graph = new ArrayList<>();
        for(int i=0; i<numberOfNodes; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph.get(v1-1).add(v2-1);
            graph.get(v2-1).add(v1-1);
        }

        //2. Find a shortest path
        int[] answer = new int[numberOfNodes];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start-1,0));
        while(!queue.isEmpty()){
            Node element = queue.poll();
            if(element.getCount() >= numberOfNodes) break;
            else{
                if(element.getCount() > 0 && answer[element.getIndex()] == 0){
                    answer[element.getIndex()] = element.getCount()*6;
                }
                for(int next: graph.get(element.getIndex())){
                    if(next == element.getIndex()) continue;
                    queue.offer(new Node(next, element.getCount()+1));  
                }
            }   
        }
        for(int i=0; i<answer.length; i++){
            if(answer[i] == 0) answer[i] = -1;
        }
        // for(int i=0; i<numberOfNodes; i++){
        //     if(i == start-1) continue;
        //     if(graph.get(i).size() == 0){
        //         answer[i] = -1;
        //         continue;
        //     }
        //     int target = i;
        //     Queue<Node> queue = new LinkedList<>();
        //     queue.offer(new Node(start-1, 0));
        //     while(!queue.isEmpty()){
        //         Node element = queue.poll();
        //         if(element.getCount() >= numberOfNodes){
        //             answer[i] = -1;
        //             break;
        //         }else if(element.getIndex() == target && element.getCount() > 0){
        //             answer[i] = element.getCount()*6;
        //             break;
        //         }
        //         for(int next: graph.get(element.getIndex())){
        //             if(next == element.getIndex()) continue;
        //             queue.offer(new Node(next, element.getCount()+1));
        //         }
        //     }
        // }
        return answer;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        //Read Input
        int queries = Integer.parseInt(scanner.nextLine());
        for(int qItr=0; qItr<queries; qItr++){
            String[] node_edge = scanner.nextLine().split(" ");
            int numberOfNodes = Integer.parseInt(node_edge[0]);
            int numberOfEdges = Integer.parseInt(node_edge[1]);
            int[][] edges = new int[numberOfEdges][2];
            for(int i=0; i<numberOfEdges; i++){
                String[] nodeFromTo = scanner.nextLine().split(" ");
                int node_from = Integer.parseInt(nodeFromTo[0]);
                int node_to = Integer.parseInt(nodeFromTo[1]);
                edges[i][0] = node_from;
                edges[i][1] = node_to;
            }
            int start = Integer.parseInt(scanner.nextLine());
            int[] result = findShortest(numberOfNodes, edges, start);
            for(int i=0; i<result.length; i++){
                if(i == start-1) continue;
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
