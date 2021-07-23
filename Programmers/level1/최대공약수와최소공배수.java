class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = GCD(n, m);
        answer[1] = n * m / GCD(n, m);
        
        return answer;
    }
    
    public int GCD(int a, int b) {
        if(b == 0)
            return a;
        
        return GCD(b, a % b);
    }
}