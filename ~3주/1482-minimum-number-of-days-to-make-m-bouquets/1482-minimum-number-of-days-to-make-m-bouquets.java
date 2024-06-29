class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = -1;
        int min = Integer.MAX_VALUE;

        if((long)m * k > (long)bloomDay.length){
            return -1;
        }

        for(int s: bloomDay){
            if(s > max){
                max = s;
            }
            if(min > s){
                min = s;
            }
        }

        int start = min;
        int end = max;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(canMake(bloomDay, mid, m, k)){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean canMake(int[] bloomDay, int day, int m, int k){
        int bouquets = 0;
        int flowers = 0;

        for(int bloom: bloomDay){
            if(bloom <= day){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}
