package Algorithms.Sorting;

import java.util.Scanner;

public class Merge_Sort {
    
    public static void merge_sort(int[] arr){
        merge_sort(arr, 0, arr.length-1);
    }

    private static void merge_sort(int[] arr, int start, int end){

        if(start < end){
            int mid = start + (end - start) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end){

        //copy arr
        int[] copy = new int[arr.length];
        for (int i=start; i<=end; i++){
            copy[i] = arr[i];
        }

        //merge
        int i = start;
        int j = mid+1;

        for(int k=start; k<=end; k++){
            if(i > mid){
                arr[k] = copy[j++];
            }else if(j > end){
                arr[k] = copy[i++];
            }else{
                if(copy[i] < copy[j]) arr[k] = copy[i++];
                else arr[k] = copy[j++];
            }
        }
        // System.out.println(start + " " + mid + " " + end);
        // for(int element: arr){
        //     System.out.print(element + " ");
        // }
        // System.out.println();
    }

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        String[] arr = scanner.nextLine().split(" ");
        
        int[] array = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            array[i] = Integer.parseInt(arr[i]);
        }  
        
        merge_sort(array);

        for(int element: array){
            System.out.print(element + " ");
        }
    }
}
