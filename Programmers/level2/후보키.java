import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    ArrayList<String> list = new ArrayList(); // 모든 후보키
    ArrayList<List<String>> candidate = new ArrayList(); // 조건 만족 후보키
    
    public int solution(String[][] relation) {
        int answer = 0;
        boolean[] visit = new boolean[relation[0].length];
        
        for(int i = 1; i < relation[0].length; i++) {
            dfs(visit, 0, i); // 모든 후보키 추출
        }
        // 유일성
        for(int i = 0; i < list.size(); i++) {
            HashSet<String> set = new HashSet();
            String[] key = list.get(i).split("");
            
            for(int j = 0; j < relation.length; j++) {
                StringBuilder sb = new StringBuilder();
                for(String col : key) {
                    sb.append(relation[j][Integer.parseInt(col)]);
                }
                set.add(sb.toString());
            }
            
            // 최소성
            if(set.size() == relation.length) {
                List<String> cKey = Arrays.asList(key);
                boolean isMin = true;
                
                for(int j = 0; j < candidate.size(); j++) {
                    if(cKey.containsAll(candidate.get(j))) {
                        isMin = false;
                        break;
                    }
                }
                
                if(isMin) candidate.add(cKey);

            }
        }
        
        return candidate.size() == 0 ? 1 : candidate.size();
    }
    
    public void dfs(boolean[] visit, int start, int n) {
        if(n == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visit.length; i++) {
                if(visit[i]) sb.append(i);
            }
            list.add(sb.toString());
            
            return;
        } 
        
        for(int i = start; i < visit.length; i++) {
            visit[i] = true;
            dfs(visit, i + 1, n - 1);
            visit[i] = false;
        }
    }
}