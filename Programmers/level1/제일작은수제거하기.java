import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
             int[] answer = {-1};
             return answer;
         } 
        
        ArrayList<Integer> list = new ArrayList();
        
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        list.remove(Collections.min(list));
        
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
            
        return answer;
    }
}