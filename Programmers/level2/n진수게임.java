class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder number = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int count = 0;
        
        while(number.length() < m * t) {
            number.append(Integer.toString(count, n));
            count++;
        }
        
        for(int i = 0; i < t; i++) {
            answer.append(number.charAt((p - 1) + m * i));
        }
        
        return answer.toString().toUpperCase();
    }
}