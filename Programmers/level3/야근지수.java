import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        
        for(int time : works) {
            queue.add(time);
        }
        
        for(int i = 0; i < n; i++) {
            int max = queue.poll();
            if(max <= 0) return 0;
            queue.add(--max);
        }
        
        for(int time : queue) {
            answer += Math.pow(time, 2);
        }
        
        return answer;
    }
}