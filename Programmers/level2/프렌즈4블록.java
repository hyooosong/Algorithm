class Solution {
    char[][] carr;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        carr = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            carr[i] = board[i].toCharArray();
        }
        
        while(true) {
            int result = checkFour(m, n);
            if(result == 0) break;
            answer += result;
            
            dropBlock(m, n);
        }
        
        return answer;
    }
    
    public int checkFour(int m, int n) {
        boolean[][] checked = new boolean[m][n];
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                int value = carr[i][j];
                
                if(value == '.') continue;
                if(value == carr[i-1][j] && value == carr[i][j-1] && value == carr[i-1][j-1]) {
                    checked[i][j] = checked[i-1][j] = checked[i][j-1] = checked[i-1][j-1] = true;
                }
            }
        }
        
        return countBlock(m, n, checked);
    }
    
    public int countBlock(int m, int n, boolean[][] checked) {
        int cnt = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(checked[i][j]) {
                    cnt++;
                    carr[i][j] = '.';
                }
            }
        }
        
        return cnt;
    }
    
    public void dropBlock(int m, int n) {
        for(int i = m - 1; i > 0; i--) {
            for(int j = 0; j < n; j++) {
                if(carr[i][j] == '.') {
                    for(int k = i - 1; k >= 0; k--) {
                        if(carr[k][j] != '.') {
                            carr[i][j] = carr[k][j];
                            carr[k][j] = '.';
                             break;
                        }
                    }
                }
            }
        }
    }
}