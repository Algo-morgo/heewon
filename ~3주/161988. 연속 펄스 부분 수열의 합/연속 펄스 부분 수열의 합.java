import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        // int[] minusStart = new int[N];
        long[] sequenceSum = new long[sequence.length];
        sequenceSum[0] = sequence[0] < 0 ? 0 : sequence[0];
        for(int idx = 1; idx < sequence.length; idx++){
            // System.out.println(Arrays.toString(sequenceSum));
            int multi = idx % 2 == 0 ? 1 : -1;
            if(sequenceSum[idx - 1] + multi * sequence[idx] > 0){
                sequenceSum[idx] = sequenceSum[idx - 1] + multi * sequence[idx];
            }else{
                sequenceSum[idx] = 0;
            }
        }
        // System.out.println("--");
        long[] sequenceSumMinus = new long[sequence.length];
        sequenceSumMinus[0] = sequence[0] * -1 < 0 ? 0 : sequence[0] * -1;
        for(int idx = 1; idx < sequence.length; idx++){
            // System.out.println(Arrays.toString(sequenceSumMinus));
            int multi = idx % 2 == 0 ? -1 : 1;
            if(sequenceSumMinus[idx - 1] + multi * sequence[idx] > 0){
                sequenceSumMinus[idx] = multi * sequence[idx] + sequenceSumMinus[idx - 1];
            }else{
                sequenceSumMinus[idx] = 0;
            }
        }
        Arrays.sort(sequenceSum);
        Arrays.sort(sequenceSumMinus);
        // System.out.println(Arrays.toString(sequenceSum));
        // System.out.println(Arrays.toString(sequenceSumMinus));
        return Math.max(sequenceSum[sequence.length - 1],sequenceSumMinus[sequence.length - 1]);
    }
}