package Algorithms.WarmUp;

import java.util.Scanner;
import java.util.Random;

public class Example {

   public static int compute(int[] a) {
    int[] allsum = new int[(a.length*(a.length+1))/2];
    int sum = 0;
    int k = 0;
    boolean bool = false;
    for (int l=0;l<a.length;l++) {
        if (a[l]>0) bool = true;
    }
    if (bool ==false) return 0;

    for (int i=0;i<a.length;i++) {
        for (int j=i;j<a.length;j++) {
            sum +=a[j];
            allsum[k] = sum;
            k+=1;
        }
        sum = 0;
    }
    int max = allsum[0];
    for (int j=0;j<allsum.length;j++) {
        if (allsum[j]>max) max = allsum[j];
    }
    return max;
    //int max = Collections.max(Arrays.asList(allsum));
    //return max;
    /*
    Arrays.sort(allsum);
    return allsum[((a.length*(a.length+1))/2)-1];
      // Implement here.
    */
   }

   public static void main(String[] args) {
      // Do not modify the client code. 
      Scanner input = new Scanner(System.in);
      int size = input.nextInt();
      
      int[] data = new int[size];
      Random rand = new Random();
      
      for(int i=0; i<size;i++) {
         data[i] = (int)((Math.random()*10)*(rand.nextBoolean() ? -1: 1)); //ternary operator
      }
      for(int i=0; i<size;i++) {
         System.out.print(data[i]+" ");
      }
      System.out.println("\n*****************************");
      System.out.println(compute(data));
      input.close();
   }
}

