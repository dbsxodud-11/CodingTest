package Interview_Kit.Graphs;

import java.io.*;
import java.util.*;

public class Connected_Cell {

    // Complete the maxRegion function below.
    public static boolean[][] visited;
    static int maxRegion(int[][] grid) {

        visited = new boolean[grid.length][grid[0].length];
        int maximum = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                //System.out.println(i + " " + j);
                if(visited[i][j]) continue;
                else{
                    if(grid[i][j] != 0) {
                        visited[i][j] = true;
                        int count = dfs(i, j, grid);
                        maximum = (count > maximum) ? count : maximum;
                    }
                }
            }
        }
        return maximum;
    }

    private static int dfs(int x, int y, int[][] grid){
        //check every node that can be connected and filled
        int count = 1;
        if(x != grid.length-1 && grid[x+1][y] != 0 && !visited[x+1][y]){
            visited[x+1][y] = true;
            count += dfs(x+1, y, grid);
        }
        if(x != grid.length-1 && y != 0 && grid[x+1][y-1] != 0 && !visited[x+1][y-1]){
            visited[x+1][y-1] = true;
            count += dfs(x+1, y-1, grid);
        }
        if(x != grid.length-1 && y != grid[0].length-1 && grid[x+1][y+1] != 0 && !visited[x+1][y+1]){
            visited[x+1][y+1] = true;
            count += dfs(x+1, y+1, grid);
        }
        if(x != 0 && grid[x-1][y] != 0 && !visited[x-1][y]){
            visited[x-1][y] = true;
            count += dfs(x-1, y, grid);
        }
        if(x != 0 && y != 0 && grid[x-1][y-1] != 0 && !visited[x-1][y-1]){
            visited[x-1][y-1] = true;
            count += dfs(x-1, y-1, grid);
        }
        if(x != 0 && y != grid[0].length-1 && grid[x-1][y+1] != 0 && !visited[x-1][y+1]){
            visited[x-1][y+1] = true;
            count += dfs(x-1, y+1, grid);
        }
        if(y != 0 && grid[x][y-1] != 0 && !visited[x][y-1]){
            visited[x][y-1] = true;
            count += dfs(x, y-1, grid);
        }
        if(y != grid[0].length-1 && grid[x][y+1] != 0 && !visited[x][y+1]){
            visited[x][y+1] = true;
            count += dfs(x, y+1, grid);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);
        System.out.println(res);
        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}