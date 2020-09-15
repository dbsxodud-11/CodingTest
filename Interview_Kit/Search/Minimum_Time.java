package Interview_Kit.Search;

import java.io.*;
import java.util.*;

public class Minimum_Time {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {

        // Map<Long, Integer> hashmap = new HashMap<>();

        // for(int i=0; i<machines.length; i++){
        //     hashmap.put(machines[i], hashmap.getOrDefault(machines[i], 0) + 1);
        // }

        // long production = 0;
        // long time = 1;

        // while(production < goal){
        //     for(long key : hashmap.keySet()){
        //         if(time % key == 0) production += hashmap.get(key);
        //     }
        //     if(production >= goal) continue;
        //     time++;
        // }
        // return time;
        //시간 제한 - time을 씩 더하기 때문에

        //Binary Search

        long lo = 1;
        long hi = (long)Math.pow(10, 18);
        long mid = lo + (hi - lo) / 2;
        
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            // System.out.print(lo + "\t");
            // System.out.print(hi + "\t");
            // System.out.println(mid);
            
            long production = 0;
            for(int i=0; i<machines.length; i++){
                production += Math.floor(mid / machines[i]);
            }
            if (production >= goal) {
                hi = mid;
                if(hi <= lo) return mid;
            }else{
                lo = mid+1; 
                if(hi <= lo) return mid+1;
            }
        }
        System.out.println(1);
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(ans);
        scanner.close();
    }
}
