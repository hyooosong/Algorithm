import java.util.*;

class Solution {
    public long solution(long n) {
        String answer = "";
        String[] arr = new String[10];
        arr = Long.toString(n).split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return Long.valueOf(answer);
    }
}