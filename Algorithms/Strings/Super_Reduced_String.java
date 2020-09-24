package Algorithms.Strings;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Super_Reduced_String {

    public static String superReduString(String s){

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != s.charAt(i)){
                sb.append(s.charAt(i));
            }else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(sb.length() == 0) return "Empty String";
        else return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
