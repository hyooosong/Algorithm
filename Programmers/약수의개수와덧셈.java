class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int count = 0;
            for(int m = 1; m <= i; m++) {
                if(i % m == 0)
                   count++; 
            }
            
            answer = count % 2 == 0 ? answer + i : answer - i;
        }
        return answer;
    }
}