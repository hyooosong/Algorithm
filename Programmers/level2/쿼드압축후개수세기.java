class Solution {
    int[][] carr = {};
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        carr = arr;
        dfs(arr.length, 0, 0);
        return answer;
    }
    
    public void dfs(int length, int x, int y) {
        if(length == 1) {
            if(carr[x][y] == 0) answer[0]++;
            else answer[1]++;
            return;
        }
        
        if(compress(length, x, y)) return;
        
        dfs(length / 2, x, y);
        dfs(length / 2, x + length / 2, y);
        dfs(length / 2, x, y + length / 2);
        dfs(length / 2, x + length / 2, y + length / 2);
    }
    
    public boolean compress(int length, int x, int y) {
        int result = carr[x][y];
        for(int i = x; i < x + length; i++) {
            for(int j = y; j < y + length; j++) {
                if(result != carr[i][j]) return false;
            }
        }
        
        if(result == 0) answer[0]++;
        else answer[1]++;
        
        return true;
    }
}