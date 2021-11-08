import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++) {
            Stack<Character> stack = new Stack();
            int count110 = 0;
            
            for(int j = 0; j < s[i].length(); j++) {
                char now = s[i].charAt(j);
                
                if(stack.size() >= 2 && now == '0') {
                    char y = stack.pop();
                    char x = stack.pop();
                    
                    if(y == '1' && x == '1')
                        count110++;
                    else {
                        stack.push(x);
                        stack.push(y);
                        stack.push('0');
                    }
                } else {
                    stack.push(now);
                }
            }
                
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int idx = stack.size();
                
            while(!stack.isEmpty()) {
                char ch = stack.pop();
                if(!flag && ch == '1') idx--;
                if(ch == '0') flag = true;
                sb.insert(0, ch);
            }
                
            for(int k = 0; k < count110; k++)
                sb.insert(idx, "110");
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}