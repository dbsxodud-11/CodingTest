package Algorithms.Implementation;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Matrix_Layer_Rotation {
    
    public static class Layer{

        private int x1;
        private int x2;
        private int y1;
        private int y2;
        private int length;

        public Layer(int x1, int x2, int y1, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.length = ((x2 - x1) + (y2 - y1)) * 2;
        }

        public int getLength(){
            return length;
        }

        public int getX1() {return x1;}
        public int getX2() {return x2;}
        public int getY1() {return y1;}
        public int getY2() {return y2;}
    }

    static void matrixRotation(List<List<Integer>> matrix, int r) {

        //List<List<Integer>> -> int[][]
        int[][] matrix_arr = new int[matrix.size()][matrix.get(0).size()];
        int i = 0;
        int j = 0;
        for(List<Integer> row: matrix){
            for(int entry: row){
                matrix_arr[i][j++] = entry;
            }
            j = 0;
            i++;
        }

        //Get Layer
        List<Layer> layer_list = new LinkedList<>();
        for(int k=0; k<Math.min(matrix_arr.length, matrix_arr[0].length) / 2; k++){
            int x1 = k;
            int x2 = matrix_arr.length-k-1;
            int y1 = k;
            int y2 = matrix_arr[0].length - k-1;
            layer_list.add(new Layer(x1, x2, y1, y2));
        }

        //Rotation
        for(Layer layer: layer_list){
            int rotation = r % layer.getLength();
            if(rotation == 0) continue;
            else{
                for(int l=0; l<rotation; l++){
                    matrix_arr = rotation(layer, matrix_arr);
                }
            }
        }

        for(int x=0; x<matrix_arr.length; x++){
            for(int y=0; y<matrix_arr[0].length; y++){
                System.out.print(matrix_arr[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotation(Layer layer, int[][] matrix_arr){
        
        int x1 = layer.getX1();
        int x2 = layer.getX2();
        int y1 = layer.getY1();
        int y2 = layer.getY2();

        int temp = matrix_arr[x1][y1];
        //1. go to left
        for(int i=y1+1; i<=y2; i++){
            matrix_arr[x1][i-1] = matrix_arr[x1][i]; 
        }
        //2. go up
        for(int i=x1+1; i<=x2; i++){
            matrix_arr[i-1][y2] = matrix_arr[i][y2];
        }
        //3. go right
        for(int i=y2-1; i>= y1; i--){
            matrix_arr[x2][i+1] = matrix_arr[x2][i];
        }
        //4. go down
        for(int i=x2-1; i>x1; i--){
            matrix_arr[i+1][y1] = matrix_arr[i][y1];
        }
        //first element
        matrix_arr[x1+1][y1] = temp;
        return matrix_arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
