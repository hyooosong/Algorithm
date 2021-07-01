import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Collections.reverse(Arrays.asList(arr));
        
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }
}