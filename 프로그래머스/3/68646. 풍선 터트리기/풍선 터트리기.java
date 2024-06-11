import java.util.*;

class Solution {
    public int solution(int[] a) {
    
        int answer = 0;
        int N = a.length;
        
        int[] before = new int[N];
        int[] next = new int[N];
        
        int beforeMin = a[0]; // 기존꺼에서 왼쪽까지 최소
        int nextMin = a[N - 1]; // 오른쪽 최소
        
        for(int i = 0; i<N; i++){
            
            if(a[i] < beforeMin){
                beforeMin = a[i];
            }
            
            before[i] = beforeMin;
            
            if(a[N - i - 1] < nextMin){
                nextMin = a[N-i-1];
            }
            
            next[N-i-1] = nextMin;
        }
        // System.out.println(Arrays.toString(before));
        // System.out.println(Arrays.toString(next));
        for(int i = 0; i< N; i++){
            if(next[i] == a[i] || before[i] == a[i])
                answer++;
        }
        
        return answer;
    }
}