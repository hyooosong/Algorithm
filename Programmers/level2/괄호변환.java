import java.util.Stack;

class Solution {    
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        
        if(p.equals("")) return p;
        
        int end = balance(p) + 1;
        String u = p.substring(0, end);
        String v = p.substring(end);
        
        if(isCorrect(u)) {
            return u + solution(v);
        }
        
        answer.append("(").append(solution(v)).append(")");
        answer.append(reverse(u));
        
        return answer.toString();
    }
    
    public boolean isCorrect(String p) {
        Stack<Character> stack = new Stack();
        
        for(char c : p.toCharArray()) {
            if(stack.isEmpty()) 
                stack.push(c);
            else {
                if(stack.peek() == '(' && c ==')')
                    stack.pop();
                else stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
    
    public int balance(String p) {
        int close = 0;
        int open = 0;
        
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') open++;
            else close++;
            
            if(open == close) return i;
        }
        return 0;
    }
    
    public String reverse(String s) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '(') result.append(")");
            else result.append("(");
        }
        
        return result.toString();
    }
}