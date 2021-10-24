import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue();
        PriorityQueue<Integer> maxQ = new PriorityQueue(Collections.reverseOrder());
        
        for(String s : operations) {
            if(s.charAt(0) == 'D') {
                if(!minQ.isEmpty() && !maxQ.isEmpty()) {
                    if(s.substring(2).equals("1")) {
                        int max = maxQ.peek();
                        maxQ.remove(max);
                        minQ.remove(max);
                    } else {
                        int min = minQ.peek();
                        maxQ.remove(min);
                        minQ.remove(min);
                    }
                }
            } else {
                int num = Integer.valueOf(s.substring(2));
                minQ.add(num);
                maxQ.add(num);
            }
        }
        
        answer[0] = maxQ.isEmpty()? 0 : maxQ.peek();
        answer[1] = minQ.isEmpty()? 0 : minQ.peek();
        
        return answer;
    }
}