package Search;

import java.util.*;

public class Ice_Cream_Parlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        Map<Integer, Integer> hashmap2 = new HashMap<>();
        for(int i=0; i<cost.length; i++){
            if(cost[i] >= money) continue;
            if(hashmap.containsKey(cost[i])){   
                hashmap2.put(cost[i], i+1);
            }else{
                hashmap.put(cost[i], i+1);
            }
        }
        for(int key: hashmap.keySet()){
            int first = hashmap.get(key);
            if(hashmap.containsKey(money - key)){
                int second = hashmap.get(money - key);
                if(first == second) continue;
                if(first < second) System.out.println(first + " " + second);
                else System.out.println(second + " " + first);
                return;
            }
        }
        int first = hashmap.get(money / 2);
        int second = hashmap2.get(money / 2);
        System.out.println(first + " " + second);
        //money 의 값이 너무 크면 비효율적
        // if(money % 2 == 0){
        //     for(int i=1; i<=money/2; i++){
        //         if(hashmap.containsKey(i) && hashmap.containsKey(money - i)){
        //             if(i == money - i){
        //                 int a = hashmap.get(i);
        //                 int b = hashmap2.get(i);
        //                 if (a < b) System.out.println(a + " " + b);
        //                 else System.out.println(b + " " + a);
        //                 return;
        //             }else{
        //                 int a = hashmap.get(i);
        //                 int b = hashmap.get(money - i);
        //                 if (a < b) System.out.println(a + " " + b);
        //                 else System.out.println(b + " " + a);
        //                 return;
        //             }
        //         }
        //     }
        // }else{
        //     for(int i=1; i<=money/2; i++){
        //         if(hashmap.containsKey(i) && hashmap.containsKey(money - i)){
        //             int a = hashmap.get(i);
        //             int b = hashmap.get(money - i);
        //             if (a < b) System.out.println(a + " " + b);
        //             else System.out.println(b + " " + a);
        //             return;
        //         }
        //     }
        // }
        // return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
