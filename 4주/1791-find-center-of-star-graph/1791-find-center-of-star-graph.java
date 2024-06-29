import java.util.*;
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        // for(int idx =0 ; idx < edges.)
        for(int[] a :edges){
            if(map.keySet().contains(a[0])){
                map.get(a[0]).add(a[1]);
            }else{
                map.put(a[0], new HashSet<>(Arrays.asList(a[1])));
                                                            
            }
            
            if(map.keySet().contains(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                map.put(a[1], new HashSet<>(Arrays.asList(a[0])));
                                                            
            }
        }
        for(int idx : map.keySet()){
            if(map.get(idx).size() == map.keySet().size() - 1){
                return idx;
            }
        }
        
        return 1;
    
    }
}