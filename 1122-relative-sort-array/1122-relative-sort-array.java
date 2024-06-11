import java.util.*;
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[arr1.length];
        for(int a : arr1){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        HashSet<Integer> removeSet = new HashSet<>();

        removeSet.addAll(map.keySet());


        int idx = 0;
        for(int a : arr2){
            for(int time = 0; time < map.get(a); time++){
                answer[idx++] = a;
            }
            removeSet.remove(a);
        }

        ArrayList<Integer> sortedRemoveSet = new ArrayList<>();
        sortedRemoveSet.addAll(removeSet);
        sortedRemoveSet.sort(null);
        
        for(int a : sortedRemoveSet){
            for(int time = 0; time < map.get(a); time++){
                answer[idx++] = a;
            }
        }
        


        return answer;
        



    }
}