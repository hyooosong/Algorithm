import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i : arr) {
            if(i % divisor == 0) {
                answer.add(i);
            }
        }
        
        if(answer.size() == 0) {
            answer.add(-1);
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}