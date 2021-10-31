class Solution {
    int answer = 0;
    int[] pick;
    
    public int solution(int n) {
        boolean[] visit = new boolean[n];
        pick = new int[n];
        dfs(n, 0, visit);
        return answer;
    }
    
    public void dfs(int n, int idx, boolean[] visit) {
        if(n == idx) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                pick[idx] = i;
                if(check(idx)) dfs(n, idx + 1, visit);
                visit[i] = false;
            }
        }
    }
    
    public boolean check(int idx) {
        for(int i = 0; i < idx; i++) {
            if(pick[i] == pick[idx]) return false;
            if(Math.abs(idx - i) == Math.abs(pick[idx] - pick[i])) return false;
        }
        return true;
    }
}