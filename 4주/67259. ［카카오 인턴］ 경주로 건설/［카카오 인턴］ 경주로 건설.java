import java.util.*;
class Solution {
    
    static final int[] delRow = new int[]{-1, 1, 0,0};
    static final int[] delCol = new int[]{ 0,0,-1, 1};
    static int N;
    static HashMap<Integer, boolean[]> visitedMap;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        // HashMap<Integer, int[]> mapGo = new HashMap<>();
        HashMap<Integer, int[]> map90 = new HashMap<>();
        N = board.length;
        visitedMap = new HashMap<>();
        map90.put(0, new int[]{2,3});
        map90.put(1, new int[]{2,3});
        
        map90.put(2, new int[]{0,1});
        map90.put(3, new int[]{0,1});
        int[][] visited = new int[N][N];
        
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                boolean[] visitStatus = new boolean[4];
                visited[row][col] = Integer.MAX_VALUE;
                if(board[row][col] == 1){
                    visited[row][col] = -1;
                }
                
            }
        }
        
        visited[0][0] = -1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // row, col, before, amount
        
        if(board[0][1] != 1){
            queue.add(new int[]{0,1,3,100});    
        }
        if(board[1][0] != 1){
            queue.add(new int[]{1,0,1,100});    
        }
        
        
        
        while(!queue.isEmpty()){
            int[] curr = queue.pollLast();
            // System.out.println(Arrays.toString(curr) + " " + visited[curr[0]][curr[1]]);
            int r = curr[0];
            int c = curr[1];
            int beforePos = curr[2];
            int amount = curr[3];
            
            // visited[r][c] = false;
            if(r == N-1 && c == N-1){
                if(answer > amount ){
                    answer = amount ;
                }
                continue;
            }
            for(int idx:map90.get(beforePos)){
                int posR = curr[0] + delRow[idx];
                int posC = curr[1] + delCol[idx];
                if(isValid(posR, posC)){
                    // System.out.println(visited[posR][posC] + " " +(amount + 600));
                    if(visited[posR][posC] >= amount + 600){
                        
                        visited[posR][posC] = amount + 600;
                        
                        queue.add(new int[]{posR, posC, idx, amount + 600});
                    }
                }
            }
            
            if(true){
                int posR = curr[0] + delRow[beforePos];
                int posC = curr[1] + delCol[beforePos];
                if(isValid(posR, posC)){
                    // System.out.println(visited[posR][posC]+ " " +(amount + 100));
                    if(visited[posR][posC] > amount + 100){
                        visited[posR][posC] = amount + 600; // worst case고려
                        queue.add(new int[]{posR, posC, beforePos, amount + 100});
                    }
                }
            }
            
            
            
            
        }
        
        
        
        
        return answer;
    }
    
    boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
        
    }

}