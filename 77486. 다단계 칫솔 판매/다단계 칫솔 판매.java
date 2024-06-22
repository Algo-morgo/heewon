import java.util.*;
class Solution {
    static HashMap<String, String> tree;
    static HashMap<String, Integer> score;
        
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        tree = new HashMap<>();
        score = new HashMap<>();
        int personCnt = enroll.length;
        score.put("-", 0);
        for(int idx = 0; idx < enroll.length; idx++){
            tree.put(enroll[idx], referral[idx]);
            score.put(enroll[idx], 0);
        }
        System.out.println(score.get(seller[0]));
        for(int idx =0; idx < seller.length; idx++){
            addMoney(seller[idx], amount[idx] * 100);
            // System.out.println(score.toString());
        }
        answer = new int[enroll.length];
        for(int idx =0 ; idx < enroll.length; idx++){
            answer[idx] = score.get(enroll[idx]);
        }
        return answer;
    }
    
    void addMoney(String p, int amount){
        if(amount == 0 || p == null){
            
            return;
        }
        if(p.equals("-")){
            score.put("-", score.get("-") + amount);
            return;
        }
            
        int receive =(int) Math.floor(amount * 0.1);
        // if(get == null){
        //     System.out.println(get);
        //     return;
        // }
        // System.out.println(p + " " + receive + " ");
        // System.out.println(score.toString());
        // System.out.println(receive);
        score.put(p, score.get(p) + amount - receive);
        addMoney(tree.getOrDefault(p, null), receive);
        
    }
}