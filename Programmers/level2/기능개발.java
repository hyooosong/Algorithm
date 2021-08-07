import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList();
        Stack<Integer> stack = new Stack();
        int count = 0;
        
        for(int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) ++day;
                
            if(stack.empty()) {
                count++;
                stack.push(day);
            } else {
                if(stack.peek() >= day) {
                    count++;
                } else {
                    answer.add(count);
                    count = 1;
                    stack.pop();
                    stack.push(day);
                }
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}