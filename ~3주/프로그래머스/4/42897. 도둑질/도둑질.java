import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dpLastOn = new int[money.length];
        int[] dpLastNo = new int[money.length];
        
        for(int i = 0; i < money.length; i++) {
            dpLastOn[i] = money[i];
            dpLastNo[i] = money[i];
        }
        
        dpLastNo[0] = -1;
        
        
        dpLastOn[2] += dpLastOn[0];
        dpLastOn[1] = -1;
        
        
        for (int i = 3; i < money.length; i++) {
            // 2전, 3전 비교해서 넣기
            dpLastOn[i] += Math.max(dpLastOn[i - 2], dpLastOn[i - 3]);
            dpLastNo[i] += Math.max(dpLastNo[i - 2], dpLastNo[i - 3]);
        }
        
         
        return Math.max(Math.max(dpLastOn[money.length - 2], dpLastOn[money.length - 3]), Math.max(dpLastNo[money.length - 1], dpLastNo[money.length - 2]));
    
    }
}