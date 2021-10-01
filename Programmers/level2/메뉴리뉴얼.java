import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map.Entry;

class Solution {
    HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList();
        
        for(int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        for(int n : course) {
            int max = Integer.MIN_VALUE;
            map = new HashMap();
            
            for(String str : orders) {
                StringBuilder sb = new StringBuilder();
                if(n <= str.length()) 
                    dfs(str, sb, 0, 0, n);
            }
            
            for(Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            
            for(Entry<String, Integer> entry : map.entrySet()) {
                if(max >= 2 && entry.getValue() == max)
                    result.add(entry.getKey());
            }
        }
        
        String[] answer = new String[result.size()];
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    public void dfs(String str, StringBuilder sb, int idx, int cnt, int n) {
        if(cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(str, sb, i + 1, cnt + 1, n);
            sb.deleteCharAt(cnt);
        }
    }
}