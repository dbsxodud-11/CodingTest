package Graphs;

import java.io.*;
import java.util.*;

public class Find_Nearest_Clone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    public static class Node{
        private int color;
        private int index;
        private int count;

        public Node(int color, int index){
            this.color = color;
            this.index = index;
        }
        public int getColor() {
            return color;
        }

        public int getIndex() {
            return index;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
    public static Queue<Node> queue;
    public static List<List<Node>> edges;
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        //1. Construct Edges
        edges = new ArrayList<>();
        for(int i=0; i<graphNodes; i++){
            edges.add(new ArrayList<>());
        }
        
        for(int i=0; i<graphFrom.length; i++){
            int v1 = graphFrom[i];
            int color1 = (int)ids[v1-1];
            int v2 = graphTo[i];
            int color2 = (int)ids[v2-1];
            edges.get(v1-1).add(new Node(color2, v2-1));
            edges.get(v2-1).add(new Node(color1, v1-1));
        }

        Map<Long, Integer> color_map = new HashMap<>();
        for(int i=0; i<ids.length; i++){
            color_map.put(ids[i], color_map.getOrDefault(ids[i], 0)+1);
        }
        //2. Check we can find pair of node
        if(!color_map.containsKey((long)val)) return -1;
        else if(color_map.get((long)val) < 2) return -1;
        else{
            //BFS
            queue = new LinkedList<>();
            //1. find index of Node
            int start = 0;
            for(int i=0; i<ids.length; i++){
                if((int)ids[i] == val){
                    start = i+1;
                    break;
                }
            }
            Node first = new Node(val, start-1);
            first.setCount(0);
            queue.offer(first);
            while(!queue.isEmpty()){
                Node before = queue.poll();
                int count = before.getCount();
                int index = before.getIndex();
                for(Node adjacent: edges.get(index)){
                    adjacent.setCount(count+1);
                    if(adjacent.getColor() == val && adjacent.getIndex() != start-1) return adjacent.getCount();
                    else{
                        queue.offer(adjacent);
                    }
                }
            }
            return -1;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);
        System.out.println(ans);
        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}

