import java.util.*;
class Solution {
    static int[] infos;
    static int maxSheep;
    static boolean[][] connect;
    static int N;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        infos = info.clone();
        maxSheep = 1;
        N = info.length;
        connect = new boolean[N][N];
        ArrayList<Integer> nextgo = new ArrayList<>();
        // nextgo.add(0);
        
        for(int[] s: edges){
            connect[s[0]][s[1]] = true;
        }
        
        
        dfs(0, 0, 0,nextgo);
        
        return maxSheep;
    }
    
    public void dfs(int cur, int sheep, int wolf, ArrayList<Integer> cango){
        
        // System.out.println(cur + " " + sheep + " " + wolf + " " + cango.toString());
        if(infos[cur] == 0){
            sheep += 1;
        }else{
            wolf += 1;
        }
        
        if(sheep <= wolf){
            return;
        }
        if(sheep > maxSheep){
            maxSheep = sheep;
        }
        
        ArrayList<Integer> nextgo = new ArrayList<>();
        for(int n: cango){
            if(n == cur){
                continue;
            }
            nextgo.add(n);
        }
        
        for(int idx = 0; idx < N; idx++){
            if(connect[cur][idx]){
                nextgo.add(idx);
            }
        }
        // System.out.println(cur + " " + sheep + " " + wolf + " " + cango.toString());
        // System.out.println(nextgo.toString());
        
        
        for( int next: nextgo){
            dfs(next, sheep, wolf, nextgo);
        }
        

        
        
        
        
    }
}