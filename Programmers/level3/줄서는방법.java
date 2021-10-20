import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long dp = 1;
        ArrayList<Integer> num = new ArrayList();
        
        for(int i = 1; i <= n; i++) {
            num.add(i);
            dp *= i;
        }
        
        k--;
        int idx = 0;

        while(n > 0) {
            dp /= n;
            int start = (int) (k / dp);
            answer[idx++] = num.remove(start);
            k %= dp;
            n--;
        }
        
        return answer;
    }
}