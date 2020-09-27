package Algorithms.Strings;

import java.io.*;
import java.util.stream.*;

public class Maximum_Palindrome {

    public static int[][] s_char_array;

    public static void initialize(String s) {
    // This function is called once before all queries.
        s_char_array = new int[s.length()][26];
        for(int i=0; i<s_char_array.length; i++){
            int n = (int)s.charAt(i) - (int)'a';
            for(int j=0; j<26; j++){
                if(i == 0) continue;
                s_char_array[i] = s_char_array[i-1];
            }
            s_char_array[i][n] += 1;
        }
    }
    
    
    public static int answerQuery(int l, int r) {
    // Return the answer for this query modulo 1000000007.
        
        //1. check number of characters
        int[] sub_char_array = new int[26];
        if(l == 1){
            for(int i=0; i<26; i++){
                sub_char_array[i] = s_char_array[r-1][i];
            }
        }else{
            for(int i=0; i<26; i++){
                sub_char_array[i] = s_char_array[r-1][i] - s_char_array[l-2][i];
            }
        }
        

        //2. Get number of maximum palindromes
        int[] array_even = new int[26];
        int[] array_odd = new int[26];
        int even_numbers = 0;
        int odd_numbers = 0;
        for(int i=0; i<26; i++){
            array_even[i] = sub_char_array[i] / 2;
            array_odd[i] = sub_char_array[i] % 2;
            even_numbers += array_even[i];
            odd_numbers += array_odd[i];
        }

        int result = factorial(even_numbers);
        for(int i=0; i<26; i++){
            if(array_even[i] == 0) continue;
            else result = result / factorial(array_even[i]);
        }
        return result * (odd_numbers+1);
    }

    private static int factorial(int n) {

        int result = 1;
        while(n > 0){
            result *= n;
            n--;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
