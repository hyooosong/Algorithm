import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap();
    boolean[] check = new boolean[4];
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String in : info) {
            String[] info_arr = in.split(" ");
            dfs(info_arr, 0);
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for(int i = 0; i < query.length; i++) {
            ArrayList<String> list = new ArrayList();
            for(String s : query[i].split("and| ")) {
                if(!s.isEmpty()) list.add(s);
            }
            
            StringBuilder key = new StringBuilder();

            for(int j = 0; j < 4; j++) {
                if(!list.get(j).equals("-")) key.append(list.get(j));
            }
            int score = Integer.parseInt(list.get(4));
            ArrayList<Integer> scoreList = map.getOrDefault(key.toString(), new ArrayList<Integer>());
            
            int s = 0;
            int l = scoreList.size();
            while(s < l) {
                int mid = (s + l) / 2;
                if(scoreList.get(mid) < score) s = mid + 1;
                else l = mid;
            }
            answer[i] = scoreList.size() - s;
        }
        
        return answer;
    }
    
    public void dfs(String[] info_arr, int idx) {
        if(idx == 4) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++) {
                if(check[i]) sb.append(info_arr[i]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), new ArrayList<Integer>()));
            map.get(sb.toString()).add(Integer.parseInt(info_arr[4]));
            return;
        }
        
        check[idx] = true;
        dfs(info_arr, idx + 1);
        check[idx] = false;
        dfs(info_arr, idx + 1);
    }
}