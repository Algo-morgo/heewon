import java.util.*;
class Solution {
    public int appendCharacters(String s, String t) {
        
        /**
        최장 겹치는 수열 찾음되나
         */
        int max = 0;
        System.out.println(s.length());
        System.out.println(t.length());
        for(int idx = 0; idx < s.length(); idx++){
            
            if(s.charAt(idx) == t.charAt(0)){
                
                int sIdx = idx;
                int tIdx = 0;
                while(sIdx < s.length() &&  tIdx < t.length()){
                    if(s.charAt(sIdx) == t.charAt(tIdx)){
                        tIdx++;
                    }
                    sIdx++;
                }
                
                if(tIdx > max){
                    
                    max = tIdx;
                }
                if(max == t.length()){
                    return 0;
                }

            }
            
        }
        return t.length() - max;

    }   
}