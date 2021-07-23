import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> result = new ArrayList();
        
        for(int i : moves) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][i-1] != 0) {
                    result.add(board[j][i-1]);
                    board[j][i-1] = 0;
                    break;
                }
            }
            
            int size = result.size() - 1;
            if(size > 0) {
                if(result.get(size) == result.get(size - 1)) {
                    result.remove(size);
                    result.remove(size - 1);
                    answer += 2;
                }
            }
        }
        return answer;
    }
}