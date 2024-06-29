import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int idx = 0 ; idx < s.length(); idx++){
            map.put(s.charAt(idx),map.getOrDefault(s.charAt(idx), 0) + 1);
        }
        int maxOdd = 0;
        int sumEven = 0;
        System.out.println(map.toString());
        for(char ch: map.keySet()){
            
            if(map.get(ch) % 2 == 0){
                System.out.println("even");
                sumEven += map.get(ch);
                
            }else{
                if(maxOdd < map.get(ch)){
                    System.out.println("odd " + maxOdd);
                    if(maxOdd != 0){
                        sumEven += maxOdd - 1;
                    }
                    maxOdd = map.get(ch);
                }else{
                    sumEven += map.get(ch) - 1;
                }
            }
            System.out.println(ch + " " + map.get(ch));
        }
        System.out.println(maxOdd);
        System.out.println(sumEven);
        return maxOdd + sumEven;

    }
}