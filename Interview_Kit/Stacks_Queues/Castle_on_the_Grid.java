package Stacks_Queues;

import java.io.*;
import java.util.*;

public class Castle_on_the_Grid {

    public static Queue<Integer> queue = new LinkedList<>();
    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        int moves = 0;
        boolean[][] map = new boolean[grid.length][grid[0].length()];
        boolean[][] visited = new boolean[grid.length][grid[0].length()];

        for(int i=0; i<grid.length; i++){
            String[] split = grid[i].split("");
            for(int j=0; j<split.length; j++){
                map[i][j] = split[j].equals(".") ? true : false;
            }
        }

        visited[startX][startY] = true;
        dfs(map, visited, startX, startY, goalX, goalY, moves, "None");

        return queue.peek();
    }

    private static void dfs(boolean[][] map, boolean[][] visited, int startX, int startY, int goalX, int goalY, int moves, String before_action){
        //Finished
        
        if(startX == goalX && startY == goalY){
            //System.out.println(moves);
            if(queue.isEmpty()) {
                queue.offer(moves);
                return;
            }
            if(queue.peek() > moves) {
                queue.poll();
                queue.offer(moves);
                return;
            }
        }
        
        //1. Up
        if(startX > 0 && map[startX-1][startY] && !visited[startX-1][startY]){
            if(!before_action.equals("N")) moves++;
            visited[startX-1][startY] = true;
            dfs(map, visited, startX-1, startY, goalX, goalY, moves, "N");
            visited[startX-1][startY] = false;
            if(!before_action.equals("N")) moves--;
        }
        
        //2. Down
        if(startX < map.length-1 && map[startX+1][startY] && !visited[startX+1][startY]){
            if(!before_action.equals("S")) moves++;
            visited[startX+1][startY] = true;
            dfs(map, visited, startX+1, startY, goalX, goalY, moves, "S");
            visited[startX+1][startY] = false;
            if(!before_action.equals("S")) moves--;
        }

        //3. Right
        if(startY < map[0].length-1 && map[startX][startY+1] && !visited[startX][startY+1]){
            if(!before_action.equals("R")) moves++;
            visited[startX][startY+1] = true;
            dfs(map, visited, startX, startY+1, goalX, goalY, moves, "R");
            visited[startX][startY+1] = false;
            if(!before_action.equals("R")) moves--;
        }

        //4. Left
        if(startY > 0 && map[startX][startY-1] == true && !visited[startX][startY-1]){
            if(!before_action.equals("L")) moves++;
            visited[startX][startY-1] = true;
            dfs(map, visited, startX, startY-1, goalX, goalY, moves, "L");
            visited[startX][startY-1] = false;
            if(!before_action.equals("L")) moves--;
        }
        
        else return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}
