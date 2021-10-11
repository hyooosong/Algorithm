class Solution {
    int[][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        int value = 1;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = value++;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            int x = queries[i][0] - 1;
            int y = queries[i][1] - 1;
            int dx = queries[i][2] - 1;
            int dy = queries[i][3] - 1;  
            
            answer[i] = rotate(x, y, dx, dy);
        }
        
        return answer;
    }
    
    public int rotate(int x, int y, int dx, int dy) {
        int temp = arr[x][y];
        int min = temp;
        
        for(int i = x; i < dx; i++) {
            arr[i][y] = arr[i+1][y];
            if(min > arr[i][y]) min = arr[i][y];
        }
        for(int i = y; i < dy; i++) {
            arr[dx][i] = arr[dx][i+1];
            if(min > arr[dx][i]) min = arr[dx][i];
        }
        for(int i = dx; i > x; i--) {
            arr[i][dy] = arr[i-1][dy];
            if(min > arr[i][dy]) min = arr[i][dy];
        }
        for(int i = dy; i > y; i--) {
            arr[x][i] = arr[x][i-1];
            if(min > arr[x][i]) min = arr[x][i];
        }
        
        arr[x][y+1] = temp;
        
        return min;
    }
}