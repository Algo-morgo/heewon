import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int person = scores.length;
        int[] firstMin = new int[2];
        int[] secondMin = new int[2];
        int sum = scores[0][0] + scores[0][1];
        int[][] scoresPerson = new int[person][3];
        for(int idx = 0; idx < person; idx++){
            
            scoresPerson[idx][0] = scores[idx][0];
            scoresPerson[idx][1] = scores[idx][1];
            scoresPerson[idx][2] = idx;
            
        }
        
        
        Arrays.sort(scoresPerson, (x,y) -> {
            if(x[0] == y[0]){
                return x[1] - y[1];
            }
            return y[0] - x[0];
                                            });
        int max = scoresPerson[0][1];
        boolean[] failed = new boolean[person];
         for(int idx = 1; idx < person; idx++){
             if(scoresPerson[idx][1] < max){
                 if(scoresPerson[idx][2] == 0){
                     return -1;
                 }
                 failed[scoresPerson[idx][2]] = true;
             }else{
                 max = scoresPerson[idx][1];
             }
         }
        Arrays.sort(scoresPerson, (x,y) -> {
            
            if(- x[0] - x[1] + y[0] + y[1] == 0){
                return x[2] - y[2];
            }
            return - x[0] - x[1] + y[0] + y[1];
                                            });
        // for(int[] s: scoresPerson){
        //     System.out.println(Arrays.toString(s));
        // }
        // System.out.println();
        // System.out.println(Arrays.toString(failed));
        // int rank = 0
        for(int idx = 1; idx < person; idx++){
            // if(scoresPerson[idx][2] == 0){
            //     answer++;
            //     break;
            // }else{
            //     if(!failed[idx]){
            //         answer++;
            //     }
            // }
            if(scores[idx][0] + scores[idx][1] > sum && !failed[idx]){
                answer++;
            }
        }
        
        return answer;
    }
}