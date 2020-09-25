package Algorithms.Strings;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Highset_Value_Palindrome {

    public static String highestValuePalindrome(String s, int n, int k){

        //1. Make a int array
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(Character.toString(s.charAt(i)));
        }
        
        int count = 0;
        Map<Integer, Boolean> hashmap = new HashMap<>();
        //2. Make a palindrome
        int index = 0;
        while(index < n/2){
            if(arr[index] != arr[n-index-1]) {
                if(arr[index] > arr[n-index-1]) {
                    arr[n-index-1] = arr[index];
                    hashmap.put(n-index-1, true);
                }else {
                    arr[index] = arr[n-index-1];
                    hashmap.put(index, true);
                }
                count++;
            } 
            index++;
        }

        //3. Maximize a palindrome
        if(count > k) return "-1";
        else{
            index = 0;
            while(count < k && index < n){
                if(arr[index] != 9){
                    if(hashmap.containsKey(index)){
                        count++;
                        arr[index] = 9;
                        arr[n-index-1] = 9;
                    }else if(hashmap.containsKey(n-index-1)){
                        count++;
                        arr[index] = 9;
                        arr[n-index-1] = 9;
                    }else{
                        if(n%2 == 1 && index == n/2){
                            count++;
                            arr[index] = 9;
                        }else{
                            if(count+2 > k) {
                                index++;
                                continue;
                            }else{
                                arr[index] = 9;
                                arr[n-index-1] = 9;
                                count += 2;
                            } 
                        }
                    }
                }
                index++; 
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]);
            }
            return sb.toString();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);
        System.out.println(result);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
