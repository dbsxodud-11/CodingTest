package Algorithms.Implementation;

import java.util.Scanner;

public class Apple_Oranges {
 
    public static void countAppleOranges(int s, int t, int a, int b, int[] apples, int[] oranges){
        int apples_in = 0;
        int oranges_in = 0;

        int s_to_a = s - a;
        int t_to_a = t - a;
        int b_to_s = s - b;
        int b_to_t = t - b;

        //1. Count apple
        for(int i=0; i<apples.length; i++){
            if(apples[i] >= s_to_a && apples[i] <= t_to_a) apples_in++;
        }
        for(int i=0; i<oranges.length; i++){
            if(oranges[i] <= b_to_t && oranges[i] >= b_to_s) oranges_in++;
        }

        System.out.println(apples_in);
        System.out.println(oranges_in);
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);
        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countAppleOranges(s, t, a, b, apples, oranges);
        scanner.close();
    }
}
