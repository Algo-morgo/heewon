import java.util.*;
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        int groupCnt = hand.length / groupSize;
        boolean[] visited = new boolean[hand.length];
        int before = 0;
        int cnt = 0;
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> keyList = new ArrayList<>();
        for(int a: hand){
            if(!map.keySet().contains(a)){
                keyList.add(a);
            }
            map.put(a, map.getOrDefault(a,0) + 1);
        }

        keyList.sort(null);
        
        while(keyList.size() != 0){
            int min = keyList.get(0);
            int minCnt = map.get(min);
            for(int idx = 0; idx < groupSize; idx++){
                if(minCnt > map.getOrDefault(idx + min, 0)){
                    return false;
                }
                if(map.getOrDefault(idx + min, 0) == minCnt){
                    map.remove(idx + min);
                    keyList.remove(Integer.valueOf(idx + min));
                }else{
                    map.put(idx + min, map.get(idx + min) - minCnt);
                }


            }
            keyList.sort(null);

        }
        

        return true;
    }
}