import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        
        for(int i : priorities) {
            q.add(i);
        }
        
        while(!q.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == q.peek()) {
                    if(location == i) return answer;
    
                    answer++;
                    q.poll();
                }
            }
        }
        return answer;
    }
}