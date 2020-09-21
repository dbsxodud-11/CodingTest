package Algorithms.Implementation;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Magic_Square {

    public static int formingMagicSquare(int[][] s){
        //1. Brute Force - check every possible choices
        int[][] candidate_1 = new int[3][3];
        candidate_1[0][0] = 6;
        candidate_1[0][1] = 7;
        candidate_1[0][2] = 2;
        candidate_1[1][0] = 1;
        candidate_1[1][1] = 5;
        candidate_1[1][2] = 9;
        candidate_1[2][0] = 8;
        candidate_1[2][1] = 3;
        candidate_1[2][2] = 4;

        int[][] candidate_2 = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                candidate_2[i][j] = candidate_1[2-i][j];
            }
        }

        int[][] candidate_3 = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                candidate_3[i][j] = candidate_1[i][2-j];
            }
        }

        int[][] candidate_4 = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                candidate_4[i][j] = candidate_2[i][2-j];
            }
        }

        int[][] candidate_5 = new int[3][3];
        candidate_5[0][0] = 4;
        candidate_5[0][1] = 9;
        candidate_5[0][2] = 2;
        candidate_5[1][0] = 3;
        candidate_5[1][1] = 5;
        candidate_5[1][2] = 7;
        candidate_5[2][0] = 8;
        candidate_5[2][1] = 1;
        candidate_5[2][2] = 6;

        int[][] candidate_6 = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                candidate_6[i][j] = candidate_5[2-i][j];
            }
        }

        int[][] candidate_7 = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                candidate_7[i][j] = candidate_5[i][2-j];
            }
        }

        int[][] candidate_8 = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                candidate_8[i][j] = candidate_6[i][2-j];
            }
        }
        List<int[][]> candidate_list = new ArrayList<>();
        candidate_list.add(candidate_1);
        candidate_list.add(candidate_2);
        candidate_list.add(candidate_3);
        candidate_list.add(candidate_4);
        candidate_list.add(candidate_5);
        candidate_list.add(candidate_6);
        candidate_list.add(candidate_7);
        candidate_list.add(candidate_8);

        int minimum = 81;
        int cost = 0;
        for(int i=0; i<8; i++){
            int[][] candidate = candidate_list.get(i);
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    cost += Math.abs(candidate[j][k] - s[j][k]);
                }
            }
            minimum = (minimum > cost) ? cost : minimum;
            cost = 0;    
        }
        return minimum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
