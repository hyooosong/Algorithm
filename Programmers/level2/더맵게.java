import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        for(int i : scoville) {
            queue.add(i);
        }
        
        while(queue.peek() < K) {
            if(queue.size() < 2) 
                return -1;
            
            int min = queue.peek();
            queue.poll();
            min = min + (2 * queue.peek());
            queue.poll();
            queue.add(min);
            answer++;
        }
        
        return answer;
    }
}