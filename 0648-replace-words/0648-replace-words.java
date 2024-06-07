import java.util.*;
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(null);
        ArrayList<String> set = new ArrayList<>();
        boolean[] isVisited = new boolean[dictionary.size()];
        // System.out.println(dictionary.toString());
        // System.out.println(Arrays.toString(isVisited));
        for(int idx = 0; idx < dictionary.size(); idx++){
            if(isVisited[idx]){
                continue;
            }
            for( int next = idx + 1; next < dictionary.size(); next++){
                if(isVisited[idx]){
                    continue;
                }
                // System.out.println("?");
                if(isPre(dictionary.get(idx), dictionary.get(next))){
                    isVisited[next] = true;
                }
            }

            set.add(dictionary.get(idx));
        }
        String[] splitSen = sentence.split(" ");
        String answer = "";
        // System.out.println(set.toString());
        // System.out.println("++");
        for(String sp: splitSen){
            
            String target = sp;
            for(int idx = 0; idx < set.size(); idx++){
                boolean result = isPre(set.get(idx), sp);
                
                // System.out.println(set.get(idx) + " "  +sp + " " + result);
                if(result){
                    target = set.get(idx);
                    break;
                }
            }
            answer += target;
            answer += " ";

        }
        return answer.substring(0, answer.length() - 1);
    }

    public boolean isPre(String pre, String sen){
        // System.out.println(pre + " " + sen);
        if(sen.length() < pre.length()){
            return false;
        }
        for(int idx = 0; idx < pre.length(); idx++){
            if(pre.charAt(idx) != sen.charAt(idx)){
                return false;
            }
        }
        return true;
    }
}