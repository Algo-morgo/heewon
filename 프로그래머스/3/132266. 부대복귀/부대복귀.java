import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        
        // int[][] map = new int[n+1][n+1];
        int[] dist = new int[n+1];
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for(int idx = 0; idx < n + 1; idx++){
            map.add(new ArrayList<>());
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });
        for(int[] road : roads){
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
            
            
            if(road[0] == destination){
                dist[road[1]] = 1;
                queue.add(new int[]{road[1], 1});
            }
            if(road[1] == destination){
                dist[road[0]] = 1;
                queue.add(new int[]{road[0], 1});
            }
        }
        
        
        
        dist[destination] = 0;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            // System.out.println(Arrays.toString(curr));
            for(int next : map.get(curr[0])){
                
                // System.out.print(idx + " ");
                int distance = curr[1] + 1;
                if(distance < dist[next]){
                    dist[next] = distance;
                    queue.add(new int[]{next, distance});
                }
            }
        }
        System.out.println();
//         for(int[] a: map){
//             // System.out.println(Arrays.toString(a));
            
//         }
//         System.out.println(Arrays.toString(dist));
        answer = new int[sources.length];
        for(int idx = 0; idx< sources.length; idx++){
            if(dist[sources[idx]] != Integer.MAX_VALUE){
                answer[idx] = dist[sources[idx]];
            }else{
                answer[idx] = -1;
            }
        }
        
        
        return answer;
        
    }
}