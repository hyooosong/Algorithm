import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap();
        
        for(String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for(String list : completion) {
            hm.put(list, hm.get(list) - 1);
        }
        
        for(String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                return key;
            }
        }
        
        return answer;
    }
}