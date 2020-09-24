package Algorithms.Sorting;

import java.util.Scanner;

public class Insertion_Sort {

    public static int[] insertion_sort(int[] array){

        for(int i=1; i<array.length; i++){
            int key = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        String[] arr = scanner.nextLine().split(" ");
        
        int[] array = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            array[i] = Integer.parseInt(arr[i]);
        }  
        int[] sorted = insertion_sort(array);

        for(int element: sorted){
            System.out.print(element + " ");
        }
    }
}
