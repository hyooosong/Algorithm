class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder remains = new StringBuilder();
        
        while (n > 0) {
            remains.append(n % 3);
            n /= 3;
        }
                
        return Integer.parseInt(String.valueOf(remains), 3);
    }
}