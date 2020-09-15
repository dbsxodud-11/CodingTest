package Interview_Kit.Stacks_Queues;

import java.io.*;
import java.util.*;

public class Balanced_Brackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.push('(');
            if(s.charAt(i) == '{') stack.push('{');
            if(s.charAt(i) == '[') stack.push('[');
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()) return "NO";
                if(stack.peek() == '(') stack.pop();
                else return "NO";
            }
            if(s.charAt(i) == '}'){
                if(stack.isEmpty()) return "NO";
                if(stack.peek() == '{') stack.pop();
                else return "NO";
            }
            if(s.charAt(i) == ']'){
                if(stack.isEmpty()) return "NO";
                if(stack.peek() == '[') stack.pop();
                else return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}