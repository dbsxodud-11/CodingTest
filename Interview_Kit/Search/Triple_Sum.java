package Interview_Kit.Search;

import java.io.*;
import java.util.*;

public class Triple_Sum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        //int max_length = Math.max(Math.max(a.length, b.length), c.length);
        int answer = 0;
        int a_count = 0;
        int c_count = 0;
        int j = 0;
        int k = 0;
        for(int i=0; i<b.length; i++){
            while(j < a.length && a[j] <= b[i]) {
                if(j > 0 && a[j] == a[j-1]) {
                    j++;
                    continue;
                }else{
                    a_count++;
                    j++;
                }
            }
            while(k < c.length && c[k] <= b[i]) {
                if(k > 0 && c[k] == c[k-1]) {
                    k++;
                    continue;
                }else{
                    c_count++;
                    k++;
                }
            }
            //System.out.println(k);
            if(i > 0 && b[i] == b[i-1]) continue;
            answer += a_count * c_count;  
        }
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(ans);
        scanner.close();
    }
}