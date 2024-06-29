import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int last = -1;
        for(int station: stations){
            int left = station - w - 1;
            int right = station + w - 1;
            
            if(left < 0){
                left = 0;
            }
            if(right >= n){
                right = n - 1;
            }
            
            if(left > last){
                answer += (int)Math.ceil((double)(left - last - 1) / (2*w + 1));
            }
            last = right;
        }
       
        if(last < n - 1){
            answer += (int)Math.ceil((double)(n - last - 1) / (2*w + 1));
        }
        
        return answer;
    }
}