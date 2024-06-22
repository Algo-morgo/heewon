class Solution {
    public boolean judgeSquareSum(int c) {
        if(Math.sqrt(c) == Math.floor(Math.sqrt(c))){
            return true;
        }
        for(int idx = 1; idx <= (int) Math.ceil(Math.sqrt(c)); idx++){
            int a = c - idx*idx;
            if(Math.sqrt(a) == Math.floor(Math.sqrt(a))){
                return true;
            }
        }
        return false;
    }
}