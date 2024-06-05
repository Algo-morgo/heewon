class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<String, Integer> map = mapper(words[0]);
        for(int idx = 0; idx < words.length; idx++){
            HashMap<String, Integer> comp = mapper(words[idx]);
            // System.out.println(comp.toString());
            Set<String> co = comp.keySet();
            co.retainAll(map.keySet());
            Set<String> pastSet = new HashSet<>();
            for(String s: map.keySet()){
                pastSet.add(s);
            }
            // System.out.println(co.toString());
            for(String a: pastSet){
                if(!co.contains(a)){
                    map.remove(a);
                }else{
                    int smaller = map.get(a) < comp.get(a) ? map.get(a) : comp.get(a);
                    map.put(a, smaller);
                }
            }
            // System.out.println(map.toString());

        }
        List<String> answer = new ArrayList<>();
        for(String s : map.keySet()){
            for(int idx = 0; idx < map.get(s); idx++){
                answer.add(s);
            }
            
        }
        return answer;
        
    }

    HashMap<String, Integer> mapper(String a){
        HashMap<String, Integer> value = new HashMap<>();
        for(int idx = 0; idx < a.length(); idx++){
            String sub = a.substring(idx, idx+1);
            value.put(sub, value.getOrDefault(sub, 0) + 1);
            
        }
        return value;
    }
}