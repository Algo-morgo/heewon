import java.util.*;
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        ArrayList<int[]> arr = new ArrayList<>();
        ArrayList<Integer> weight = new ArrayList<>();
        long answer = 0;
        weight.add(0);
        arr.add(new int[]{0,0});
        for(int idx = 0; idx < n; idx++){
            arr.add(new int[]{idx + 1,0});
            weight.add(0);
        }
        for(int[] road : roads){
            int[] a = arr.get(road[0]);
            a[1] += 1;
            arr.set(road[0], a);
            int[] b = arr.get(road[1]);
            b[1] += 1;
            arr.set(road[1], b);
        }
        arr.sort((x, y)->{
            return - x[1] + y[1];
        });
        int s = n;
        for(int[] a: arr){
            // System.out.println(Arrays.toString(a));
            weight.set(a[0], s--);
        }
        for(int[] road : roads){
            int sum = weight.get(road[0]) + weight.get(road[1]);
            answer += (long) sum;
        }
        return answer;
        
        
    }
}