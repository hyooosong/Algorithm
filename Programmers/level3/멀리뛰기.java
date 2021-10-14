class Solution {
    public long solution(int n) {
        int[] jump = new int[2000];
        jump[1] = 1;
        jump[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            jump[i] = (jump[i - 1] + jump[i - 2]) % 1234567;
        }
        
        return jump[n];
    }
}