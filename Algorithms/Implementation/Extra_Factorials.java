package Algorithms.Implementation;

import java.util.Scanner;

public class Extra_Factorials {

    public static void extraLongFactorials(int n){
        int[] numbers = new int[200];
        numbers[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<numbers.length; j++){
                numbers[j] *= i;
            }
            for(int j=0; j<numbers.length; j++){
                if(numbers[j] < 10) continue;
                else if(numbers[j] < 100){
                    numbers[j+1] += numbers[j] / 10;
                    numbers[j] = numbers[j] % 10;
                }else{
                    numbers[j+2] += numbers[j] / 100;
                    numbers[j+1] += (numbers[j] % 100) / 10;
                    numbers[j] = (numbers[j] % 100) % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=199; i>=0; i--){
            if(sb.length() == 0 && numbers[i] == 0) continue;
            else sb.append(numbers[i]);
        }
        System.out.println(sb.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
