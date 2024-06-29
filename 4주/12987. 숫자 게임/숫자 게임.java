import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aidx = 0;
        int bidx = 0;
        while(aidx < A.length && bidx< A.length){
            // System.out.println(A[aidx] + " " + B[bidx]);
            if(A[aidx] < B[bidx]){
                aidx++;
                answer++;
            }
            bidx++;
        }
        return answer;
    }
}