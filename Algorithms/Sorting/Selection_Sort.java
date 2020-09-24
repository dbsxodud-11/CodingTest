package Algorithms.Sorting;

import java.util.Scanner;

public class Selection_Sort {
    
    public static int[] selection_sort(int[] array){

        for(int i=0; i<array.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<array.length; j++){
                minIndex = (array[minIndex] > array[j]) ? j: minIndex;
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
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
        int[] sorted = selection_sort(array);

        for(int element: sorted){
            System.out.print(element + " ");
        }
    }
}
