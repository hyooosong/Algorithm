import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int size = n;
        
        for(String s : cmd) {
            char query = s.charAt(0);
            switch(query) {
                case 'D' : {
                    k += Integer.parseInt(s.substring(2));
                    break;
                }
                case 'U' : {
                    k -= Integer.parseInt(s.substring(2));
                    break;
                }
                case 'C' : {
                    stack.push(k);
                    size--;
                    if(k == size) k--;
                    break;
                }
                case 'Z' : {
                    if(stack.pop() <= k) k++;
                    size++;
                    break;
                } 
            }
        }
        
        for(int i = 0; i < size; i++) {
           answer.append('O'); 
        } 
        while(!stack.isEmpty()) {
            answer.insert(stack.pop().intValue(), 'X');
        }
        return answer.toString();
    }
}