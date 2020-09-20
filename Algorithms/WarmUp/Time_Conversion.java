package Algorithms.WarmUp;

import java.io.*;
import java.util.*;

public class Time_Conversion {
    
    public static String timeConversion(String s){

        String format =  s.substring(8, 10);
        String[] s_split = s.substring(0, 8).split(":");
        
        if(format.equals("PM") && !s_split[0].equals("12")){
            s_split[0] = Integer.toString(Integer.parseInt(s_split[0]) + 12);
        }
        if(format.equals("AM") && s_split[0].equals("12")){
            s_split[0] = "0" + Integer.toString(Integer.parseInt(s_split[0]) - 12);
        }
        
        return s_split[0] + ":" + s_split[1] + ":" + s_split[2];
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        //BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();

        String result = timeConversion(s);

        //bufferedwriter.write(result);
        //bufferedwriter.newLine();

        //bufferedwriter.close();
        System.out.println(result);
        scanner.close();
    }
}
