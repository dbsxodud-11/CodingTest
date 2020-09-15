package Interview_Kit.Greedy_Algorithms;

import java.io.*;
import java.util.*;

public class Reverse_Shuffle_Merge {

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        int[] addCount = new int[26];
        int[] skipCount = new int[26];

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            addCount[s.charAt(i) - 'a']++;
            skipCount[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<addCount.length; i++){
            addCount[i] = addCount[i]/2;
            skipCount[i] = skipCount[i]/2;
        }

        for(int i=s.length() - 1; i>=0; i--){
            //System.out.println(s.charAt(i));
            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && addCount[s.charAt(i) - 'a'] > 0 && skipCount[stack.peek() - 'a'] > 0){
                char c = stack.pop();
                addCount[c - 'a']++;
                skipCount[c - 'a']--;
            }
            if(addCount[s.charAt(i) - 'a'] > 0) {
                stack.push(s.charAt(i));
                addCount[s.charAt(i) - 'a']--;
            }else{
                skipCount[s.charAt(i) - 'a']--;
            }
        }

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}