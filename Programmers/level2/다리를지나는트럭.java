import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        int sum = 0;
        int idx = 0;
        Queue<Integer> queue = new LinkedList();

        while(idx < truck_weights.length) {
            if(queue.size() >= bridge_length) {
                sum -= queue.peek();
                queue.poll();
            }
            
            if(sum + truck_weights[idx] <= weight) {
                queue.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                queue.add(0);
            }
            
            answer++;
        }
        
        return answer;
    }
}