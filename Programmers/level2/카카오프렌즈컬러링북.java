class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visit;
    int cnt = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visit = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visit[i][j]) {
                    numberOfArea++;
                    dfs(picture, m, n, i, j);
                }
                
                if(cnt > maxSizeOfOneArea) 
                    maxSizeOfOneArea = cnt;
        
                cnt = 0;
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public void dfs(int[][] pic, int m, int n, int x, int y) {
        if(visit[x][y]) return;
        visit[x][y] = true;
        cnt++;
        
        for(int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            
            if(tempX < 0 || tempX >= m || tempY < 0 || tempY >= n) continue;
            if(pic[x][y] == pic[tempX][tempY] && !visit[tempX][tempY]) 
                dfs(pic, m, n, tempX, tempY);
        }
    }
}