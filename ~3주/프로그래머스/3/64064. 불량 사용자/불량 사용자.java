import java.util.*;
class Solution {
    static int ruleCnt;
    static String[] bannedId;
    static Set<Set<String>> result;
    static HashMap<String, Set<String>> map;
    public int solution(String[] user_id, String[] banned_id) {
        ruleCnt = banned_id.length;
        bannedId = banned_id.clone();
        int answer = 0;
        result = new HashSet<>();
        Set<String> setRule = new HashSet<>();
        for(String rule: banned_id){
            setRule.add(rule);
        }
        map = new HashMap<>();
        for(String rule: setRule){
            Set<String> arr = new HashSet<>();
            for(String id: user_id){
                if(isBan(rule, id)){
                    arr.add(id);
                }
            }
            map.put(rule, arr);
        }
        // System.out.println(map.toString());
        per(0, new HashSet<>());
        // System.out.println(result.toString());
        
        
        
        
        // System.out.println(total.toString());
        
        return result.size();
    }
    
    public void per(int idx, Set<String> sets){
        
        if(idx == ruleCnt){
            result.add(sets);
            return;
        }
        // System.out.println(bannedId[idx] + " " + sets.toString());
        Set<String> arr = map.get(bannedId[idx]);
        for(String a : arr){
            if(sets.contains(a)){
                continue;
            }
            HashSet<String> next =new HashSet<>();
            next.addAll(sets);
            next.add(a);
            per(idx + 1, next);
            
        }
    }
    
    
    
    
    
    boolean isBan(String pre, String id){
        if(id.length() != pre.length()){
            return false;
        }
        
        for(int idx = 0 ; idx < pre.length(); idx++){
            if(pre.charAt(idx) == '*'){
                continue;
            }
            if(pre.charAt(idx) != id.charAt(idx)){
                return false;
            }
        }
        return true;
    }
}