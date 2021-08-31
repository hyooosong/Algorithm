class Solution
{
    public int solution(int [][]board)
    {
        int max = board[0][0];
        
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] > 0) {
                    int min = Math.min(board[i-1][j-1], Math.min(board[i][j-1], board[i-1][j]));
                    board[i][j] += min;
                }
                
                if(max < board[i][j]) 
                    max = board[i][j];
            }
        }

        return max * max;
    }
}