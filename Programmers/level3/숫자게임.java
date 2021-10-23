import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] < B[idx]) answer++;
            else i--;
            
            idx++;
            if(idx == B.length) break;
        }
        
        return answer;
    }
}