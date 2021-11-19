class Solution {
    int answer = -1;
    boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int tired, int[][] dungeons, int idx) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && dungeons[i][0] <= tired) {
                visit[i] = true;
                dfs(tired - dungeons[i][1], dungeons, idx + 1);
                visit[i] = false;
            }
        }
        
        if(answer < idx) answer = idx;
    }
}