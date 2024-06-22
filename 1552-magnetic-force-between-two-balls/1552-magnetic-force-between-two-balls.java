import java.util.*;
class Solution {
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int answer = 0;
        int start = Integer.MAX_VALUE;
        int end = -1;
        for(int a : position){
            if(a < start){
                start = a;
            }
            if(a > end){
                end = a;
            }
        }
        start = 0;
        end += 1;
        // System.out.println(canMake(position, 5, m));
        int width = start + end;
        while(start < end){
            width = (start +end)/ 2;
            // System.out.println(width);
            boolean check = canMake(position, width, m);
            // System.out.println(check);
            if(check){
                answer = width;
                start = width + 1;
            }else{
                end = width;
            }
        }
        return answer;
    }
    
    public boolean canMake(int[] position, int k, int m){
        int cnt = 1;
        int before = position[0];
        for(int idx = 1; idx < position.length; idx++){
            if(position[idx] >= before + k){
                before = position[idx];
                cnt+=1;
            }
        }
        if(cnt >= m){
            return true;
        }
        return false;
    }
}