import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            if(!stack.empty()) {
                if(s.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                else 
                    stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
            
        }
        return stack.empty() ? true : false;
    }
}