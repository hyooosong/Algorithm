import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
  
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String before, String next) {
                return before.charAt(n) == next.charAt(n) ? before.compareTo(next) : before.charAt(n) - next.charAt(n);
            }
        });
        return strings;
    }
}