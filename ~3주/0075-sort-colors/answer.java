import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int a : nums){
            map.put(a, map.getOrDefault(a,0)+1);
        }
        //System.out.println(map.toString());
        int idx = 0;
        for(int a : new int[]{0,1,2}){
            for(int t=0; t< map.getOrDefault(a,0); t++){
                nums[idx++]=a;
            }
        }
    
    }
}
