package Algorithms.Strings;

import java.util.Scanner;

public class DNA_health {

    public static int gene_health_value(String[] genes, int[] health, int start, int end, String d){

        //1. Brute Force
        int health_value = 0;
        for(int i=start; i<=end; i++){
            for(int j=0; j<=d.length()-genes[i].length(); j++){
                System.out.println(d.substring(j, j+genes[i].length()) + "\t" + genes[i]);
                if(d.substring(j, j+genes[i].length()).equals(genes[i])){
                    health_value += health[i];
                }
            }
        }
        return health_value;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];

            int candidate = gene_health_value(genes, health, first, last, d);
            min = (candidate < min) ? candidate : min;
            max = (candidate > max) ? candidate : max;
            System.out.println(min + " " + max);
        }


        scanner.close();
    }
}
