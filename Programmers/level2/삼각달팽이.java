class Solution {
    public int[] solution(int n) {
        int sum = n * (n + 1) / 2;
        int[][] arr = new int[n][n];
        int[] answer = new int[sum];
        int x = 0, y = 0, now = 1;
  
        arr[0][0] = 1;
        while(now < sum) {
            while(x + 1 < n && arr[x+1][y] == 0) {
                arr[++x][y] = ++now;
            }
            while(y + 1 < n && arr[x][y+1] == 0) {
                arr[x][++y] = ++now;
            }
            while(x - 1 > 0 && arr[x-1][y-1] == 0) {
                arr[--x][--y] = ++now;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) break;
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}