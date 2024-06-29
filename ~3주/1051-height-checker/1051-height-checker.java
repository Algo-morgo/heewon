import java.util.*;
class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedHieghts = heights.clone();
        int answer = 0;
        Arrays.sort(sortedHieghts);
        for(int idx = 0 ; idx < heights.length; idx++){
            if(heights[idx] != sortedHieghts[idx]){
                answer++;
            }
        }
        return answer;
    }
}