import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                answer += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
                
            }
        }
        
        return answer;
    }
}
