import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int time = 0;
        int answer = 0;
        int cnt = 0;
        int idx = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                queue.add(jobs[idx++]);
            }
            
            if(queue.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] arr = queue.poll();
                answer += time + arr[1] - arr[0];
                time += arr[1];
                cnt++;
            }
        }
    
        return answer / jobs.length;
    }
}