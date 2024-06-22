import java.util.*;

class Solution {
	public int[] solution(String[] gems) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> cntMap = new HashMap<>();
        int start = 0;
        int end = Integer.MAX_VALUE;
        
        for(String g : gems){
            set.add(g);
        }
        int startPoint = 0;
        for(int i = 0; i < gems.length; i++) {
            cntMap.put(gems[i], cntMap.getOrDefault(gems[i], 0) + 1);
            // 추가
            queue.add(gems[i]);
            
            while(true) {
                String temp = queue.peek();
                if(cntMap.get(temp) > 1) { // 2개이상
                    start++;
                    queue.poll();
                    cntMap.put(temp, cntMap.get(temp) -1);
                }
                else {
                    break;
                }
            }
            if(cntMap.size() == set.size() && end > queue.size()) {
                // 갱신
                end = queue.size();
                startPoint = start;
            }
        }
        return new int[] {startPoint+1, startPoint+ end};
        // return new int[]{};
    }
}