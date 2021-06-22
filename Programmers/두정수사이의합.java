class Solution {
    public long solution(long a, long b) {
        long answer = 0;
        
        answer = (Math.abs(a - b)+1) * (a + b) / 2;
        return answer;
        
    }
}