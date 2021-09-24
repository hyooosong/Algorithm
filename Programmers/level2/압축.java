import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList();
        int idx = 1;
        HashMap<String, Integer> map = new HashMap();
        boolean isEnd = false;
        
        for(char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), idx++);
        }
        
        for(int i = 0; i < msg.length(); i++) {
            String now = String.valueOf(msg.charAt(i));
            int len = 1;
            
            while(map.containsKey(now)) {
                if(i + len >= msg.length()) {
                    isEnd = true;
                    break;
                }
                now += msg.charAt(i + len++);
            }
            
            if(isEnd) {
                answer.add(map.get(now));
                break;
            }
            
           answer.add(map.get(msg.substring(i, i + now.length() - 1)));
           map.put(now, idx++);

           i += len - 2;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}