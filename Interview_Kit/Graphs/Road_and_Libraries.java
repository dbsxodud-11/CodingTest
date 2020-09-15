package Interview_Kit.Graphs;

import java.io.*;
import java.util.*;

public class Road_and_Libraries {

    static boolean[] visited;
    static List<List<Integer>> edge;
    static int count;
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if(c_lib < c_road) return (long)(n*c_lib);
        //Store Edge in 2D array
        edge = new ArrayList<>();
        for(int i=0; i<n; i++){
            edge.add(new ArrayList<Integer>());
        }
        for(int i=0; i<cities.length; i++){
            int v1 = cities[i][0];
            int v2 = cities[i][1];
            edge.get(v1-1).add(v2-1);
            edge.get(v2-1).add(v1-1);
        }
        // for(int i=0; i<edge.length; i++){
        //     for(int j=0; j<edge.length; j++){
        //         System.out.print(edge[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
        visited = new boolean[n];
        long budget = 0;
        for(int i=0; i<n; i++){
            //visited check
            if(visited[i]) continue;
            else{
                count = 0;
                explore(i);
                budget += c_lib;
                budget += (count-1)*c_road;
            }
        }
        return budget;
    }

    private static void explore(int i){
        visited[i] = true;
        count++;
        for(int j : edge.get(i)){
            if(!visited[j]) {
                explore(j);
            } 
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
