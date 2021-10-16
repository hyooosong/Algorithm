class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        
        int cnt = 0;
        int remain = s % n;
        while(cnt < remain) {
            answer[--n]++;
            cnt++;
        }
        
        return answer;
    }
}