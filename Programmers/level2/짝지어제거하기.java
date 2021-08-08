import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack();
        
        for(String str : s.split("")) {
            if(stack.empty()) stack.push(str);
            else {
                if(stack.peek().equals(str)) stack.pop();
                else stack.push(str);
            }
        }
        
        return stack.empty()? 1 : 0;
    }
}