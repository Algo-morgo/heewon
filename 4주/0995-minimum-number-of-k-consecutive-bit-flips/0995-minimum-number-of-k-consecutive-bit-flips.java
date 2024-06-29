import java.util.*;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= isFlipped[i - k];
            }
            if (nums[i] == flipCount) {
                if (i + k > n) {
                    return -1;
                }
                flips++;
                flipCount ^= 1;
                isFlipped[i] = 1;
            }
        }

        return flips;
    }
}
