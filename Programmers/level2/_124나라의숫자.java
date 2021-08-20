class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] num = {"4", "1", "2"};
        
        while(n > 0) { 
            answer.insert(0, num[n % 3]);
            n = n % 3 == 0 ? n/3 - 1 : n/3;
        }
        
        return answer.toString();
    }
}