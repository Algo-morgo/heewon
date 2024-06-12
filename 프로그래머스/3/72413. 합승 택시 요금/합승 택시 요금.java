import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        /*
        세가지 출발점을 기준으로 다익스트라 세번 돌려서 최솟값 찾기
        */
        s-=1;
        a-=1;
        b-=1;
        int[][] weightMap = new int[n][n];
        ArrayList<ArrayList<Integer>> connectMap = new ArrayList<>();
        int[] maxMap = new int[n];
        Arrays.fill(maxMap, Integer.MAX_VALUE);
        for(int idx = 0; idx < n; idx++){
            connectMap.add(new ArrayList<>());
            connectMap.get(idx).add(idx);
            // weightMap[idx] = maxMap.clone() ;
        }
        for(int[] fare:fares){
            int start = fare[0] - 1;
            int end = fare[1] - 1;
            int weight = fare[2];
            weightMap[start][end] = weight;
            weightMap[end][start] = weight;
            connectMap.get(start).add(end);
            connectMap.get(end).add(start);
            
        }
        
        
        int[] startDist = new int[n];
        startDist[s] = 0;
        Arrays.fill(startDist, Integer.MAX_VALUE);
        PriorityQueue<int[]> startQueue = new PriorityQueue<>((st,ed)->{
            return st[1] - ed[1];
        });
        startQueue.add(new int[]{s, 0});
        // System.out.println(startQueue.toString());
        while(!startQueue.isEmpty()){
            int[] curr = startQueue.poll();
            // System.out.println(Arrays.toString(curr));
            int start = curr[0];
            for(int next: connectMap.get(start)){
                // System.out.println(next);
                if(weightMap[start][next] + curr[1] < startDist[next]){
                    startDist[next] = weightMap[start][next] + curr[1];
                    startQueue.add(new int[]{next, startDist[next]});
                }
            }
        }
        // System.out.println(Arrays.toString(startDist));
        
        int[] ADist = new int[n];
        ADist[a] = 0;
        Arrays.fill(ADist, Integer.MAX_VALUE);
        startQueue = new PriorityQueue<>((st,ed)->{
            return st[1] - ed[1];
        });
        startQueue.add(new int[]{a, 0});
        // System.out.println(startQueue.toString());
        while(!startQueue.isEmpty()){
            int[] curr = startQueue.poll();
            // System.out.println(Arrays.toString(curr));
            int start = curr[0];
            for(int next: connectMap.get(start)){
                // System.out.println(next);
                if(weightMap[start][next] + curr[1] < ADist[next]){
                    ADist[next] = weightMap[start][next] + curr[1];
                    startQueue.add(new int[]{next, ADist[next]});
                }
            }
        }
        // System.out.println(Arrays.toString(ADist));
        
        int[] BDist = new int[n];
        BDist[b] = 0;
        Arrays.fill(BDist, Integer.MAX_VALUE);
        startQueue = new PriorityQueue<>((st,ed)->{
            return st[1] - ed[1];
        });
        startQueue.add(new int[]{b, 0});
        // System.out.println(startQueue.toString());
        while(!startQueue.isEmpty()){
            int[] curr = startQueue.poll();
            // System.out.println(Arrays.toString(curr));
            int start = curr[0];
            for(int next: connectMap.get(start)){
                // System.out.println(next);
                if(weightMap[start][next] + curr[1] < BDist[next]){
                    BDist[next] = weightMap[start][next] + curr[1];
                    startQueue.add(new int[]{next, BDist[next]});
                }
            }
        }
        // System.out.println(Arrays.toString(BDist));
        answer = Integer.MAX_VALUE;
        for(int startNext = 0; startNext < n; startNext++){
            if(startDist[startNext] == Integer.MAX_VALUE || ADist[startNext] == Integer.MAX_VALUE || BDist[startNext] == Integer.MAX_VALUE){
                continue;
            }
            int length = startDist[startNext] + ADist[startNext] + BDist[startNext];
            if(length < answer){
                answer = length;
            }
        }
        
        return answer;
    }
}