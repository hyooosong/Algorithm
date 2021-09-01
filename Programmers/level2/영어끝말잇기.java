import java.util.Stack;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Stack<String> stack = new Stack();
        stack.push(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            if(stack.indexOf(words[i]) >= 0) {
                answer = new int[]{(i % n) + 1 , (i / n) + 1};
                return answer;
            }
            
            String s = stack.peek();
            if(s.charAt(s.length() - 1) == words[i].charAt(0)) {
                stack.push(words[i]);
            } else {
                answer = new int[]{(i % n) + 1 , (i / n) + 1};
                return answer;
            }
            
        }
        return answer;
    }
}