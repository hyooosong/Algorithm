public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = Integer.toBinaryString(n);
        
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '1') answer++;
        }
        
        return answer;
    }
}