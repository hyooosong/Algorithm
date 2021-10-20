import java.util.ArrayList;

class Solution {
    ArrayList<int[]> list = new ArrayList();
    
    public int[][] solution(int n) {
        hanoi(1, 3, 2, n);
        int[][] answer = new int[list.size()][n];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int start, int end, int via, int n) {
        int[] now = new int[]{start, end};
        
        if(n == 1) {
            list.add(now);
            return;
        } else {
            hanoi(start, via, end, n - 1);
            list.add(now);
            hanoi(via, end, start, n - 1);
        }
    }
}