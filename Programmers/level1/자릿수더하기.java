public class Solution {
    public int solution(int n) {
        int answer = 0;
        String c = Integer.toString(n); 
        
        for(int i = 0; i < c.length(); i++) {
            answer += c.charAt(i) - '0';
        }

        return answer;
    }
}