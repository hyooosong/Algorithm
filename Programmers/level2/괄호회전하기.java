import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while(count < s.length()) {
            if(check(sb)) answer++;
            
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            count++;  
        }
        
        return answer;
    }
    
    public boolean check(StringBuilder sb) {
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < sb.length(); i++) {
            if(!stack.empty()) {
                if(sb.charAt(i) == ')' && stack.peek() == '('
                    || sb.charAt(i) == ']' && stack.peek() == '['
                    || sb.charAt(i) == '}' && stack.peek() == '{')
                        stack.pop();
                else 
                    stack.push(sb.charAt(i));
            } else {
                stack.push(sb.charAt(i));
            } 
        }
        return stack.isEmpty();
    }
}