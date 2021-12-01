class Solution {
    int answer;
    
    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        dfs(0, 0, number, N);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int prev, int cnt, int target, int N) {
        if(cnt > 8) return;
        
        if(prev == target) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        int calN = N;
        for(int i = 1; i < 9 - cnt; i++) {
            dfs(prev + calN, cnt + i, target, N);
            dfs(prev - calN, cnt + i, target, N);
            dfs(prev * calN, cnt + i, target, N);
            dfs(prev / calN, cnt + i, target, N);
            
            calN = calN * 10 + N;
        }
    }
}