package Stacks_Queues;

import java.io.*;
import java.util.*;

public class Castle_on_the_Grid {

    public static Queue<Node> queue = new LinkedList<>();
    // Complete the minimumMoves function below.
    public static class Node{
        private int x;
        private int y;
        private int moves;

        public Node(int x, int y, int moves){
            this.x = x;
            this.y = y;
            this.moves = moves;
        }

        public int getMoves(){
            return moves;
        }

        public int getX() {return x;}
        public int getY() {return y;}

        public boolean isEqual(Node node){
            return node.getX() == x && node.getY() == y;
        }
    }
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        boolean[][] map = new boolean[grid.length][grid[0].length()];
        int[][] visited = new int[grid.length][grid[0].length()];

        for(int i=0; i<grid.length; i++){
            String[] split = grid[i].split("");
            for(int j=0; j<split.length; j++){
                map[i][j] = split[j].equals(".") ? true : false;
            }
        }

        visited[startX][startY] = -1;
        bfs(map, visited, startX, startY, goalX, goalY);

        return queue.poll().getMoves();
    }

    private static void bfs(boolean[][] map, int[][] visited, int startX, int startY, int goalX, int goalY){

        queue.add(new Node(startX, startY, 0));
        Node end = new Node(goalX, goalY, 0);
        while(!queue.isEmpty()){
            if(queue.peek().isEqual(end)){
                break;
            }
            Node before = queue.poll();
            Set<Node> possibleMoves = possible(map, visited, before);
            for(Node node : possibleMoves){
                queue.add(node);
            }
        }
    }

    private static Set<Node> possible(boolean[][] map, int[][] visited, Node before){
        Set<Node> set = new HashSet<>();
        int startX = before.getX();
        int startY = before.getY();
        int moves = before.getMoves();
        int count = 0;
        while(startX > 0 && map[startX-1][startY] && (visited[startX-1][startY] == 0 || visited[startX-1][startY] >= moves+1)){
            startX--;
            visited[startX][startY] = moves+1;
            set.add(new Node(startX, startY, moves+1));
            count++;
        }
        while(count != 0){
            startX++;
            count--;
        }
        while(startX < map.length-1 && map[startX+1][startY] && (visited[startX+1][startY] == 0 || visited[startX+1][startY] >= moves+1)){
            startX++;
            visited[startX][startY] = moves+1;
            set.add(new Node(startX, startY, moves+1));
            count++;
        }
        while(count != 0){
            startX--;
            count--;
        }
        while(startY > 0 && map[startX][startY-1] && (visited[startX][startY-1] == 0 || visited[startX][startY-1] >= moves+1)){
            startY--;
            visited[startX][startY] = moves+1;
            set.add(new Node(startX, startY, moves+1));
            count++;
        }
        while(count != 0){
            startY++;
            count--;
        }
        while(startY < map[0].length-1 && map[startX][startY+1] && (visited[startX][startY+1] == 0 || visited[startX][startY+1] >= moves+1)){
            startY++;
            visited[startX][startY] = moves+1;
            set.add(new Node(startX, startY, moves+1));
            count++;
        }
        while(count != 0){
            startY--;
            count--;
        }
        return set;
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
