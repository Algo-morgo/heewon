class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int a= 0;
        int start = 0;
        int end = 0;
        int subSum = 0;
        int maxSum = 0;
        for(int idx = 0; idx < minutes; idx++){
            subSum += customers[idx] * grumpy[idx];
        }
        maxSum = subSum;
        
        for(int idx = 0; idx < grumpy.length; idx++){
            if(grumpy[idx] == 0){
                a += customers[idx];
            }
        }
        if(minutes >= grumpy.length){
            return subSum + a;
        }
        
        for(int startIdx = 1; startIdx < grumpy.length - minutes + 1; startIdx++){
            int next = subSum - customers[startIdx - 1]* grumpy[startIdx - 1] + customers[startIdx + minutes - 1]* grumpy[startIdx + minutes - 1];
            if(next > maxSum){
                maxSum = next;
            }
            subSum = next;
        }
        // System.out.println(a);
        // System.out.println(maxSum);
        
        
        return maxSum + a;
    }
    // [1,0,1,2,1,1,7,5]
    // [0,1,0,1,0,1,0,1]
    // [0,1,]
    
}