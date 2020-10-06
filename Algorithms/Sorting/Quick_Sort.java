package Algorithms.Sorting;

import java.util.Scanner;
import java.util.Random;

public class Quick_Sort {
    
    public static void quick_sort(int[] arr){
        quick_sort(arr, 0, arr.length-1);
    }

    private static void quick_sort(int[] arr, int p, int q){
        if(p < q){
            int r = partition(arr, p, q);
            quick_sort(arr, p, r-1);
            quick_sort(arr, r+1, q);
        }
    }

    private static int partition(int[] arr, int p, int q){
        Random random = new Random();
        int pivot = random.nextInt(q-p+1) + p;
        int pivot_element = arr[pivot];
        swap(arr, pivot, p);
        pivot = p;
        for(int i=p+1; i<=q; i++){
            if(pivot_element >= arr[i]){
                pivot++;
                swap(arr, pivot, i);
            }
        }
        swap(arr, pivot, p);
        return pivot;  
    }

    private static void swap(int[] arr, int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String[] arr = scanner.nextLine().split(" ");

        int[] array = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            array[i] = Integer.parseInt(arr[i]);
        }

        quick_sort(array);

        for(int element: array){
            System.out.print(element + " ");
        }
    }
}
