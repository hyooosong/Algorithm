import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack();
        int len_answer = number.length() - k;
        
        for(int i = 0; i < number.length(); i++) {
            char value = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < value && k > 0) {
                k--;
                stack.pop();
            }
                stack.push(value);
            }
            
        for(int i = 0; i < len_answer; i++) {
            answer.append(stack.get(i));
        }
        
        return answer.toString();
    }
}