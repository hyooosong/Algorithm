import java.util.*;

class Solution {
    public String solution(String s) {
        char[] strings = s.toCharArray();
        Arrays.sort(strings);
        StringBuilder answer = new StringBuilder(String.valueOf(strings));
        
        return answer.reverse().toString();
    }
}