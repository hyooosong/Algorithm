class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] know = new boolean[n][n];
        
        for(int[] arr : results) {
            know[arr[0] - 1][arr[1] - 1] = true;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(know[j][i] && know[i][k])
                        know[j][k] = true;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            int result = 0;
            for(int j = 0; j < n; j++) {
                if(know[i][j] || know[j][i])
                    result++;
            }
            if(result == n-1) answer++;
        }
        
        return answer;
    }
}