import java.util.ArrayList;
import java.util.Collections;

class Solution {
    boolean[] visit;
    ArrayList<String> list;
    
    public String[] solution(String[][] tickets) {
        list = new ArrayList();
        
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                visit = new boolean[tickets.length];
      
                String route = "ICN";
                visit[i] = true;
                dfs(route, tickets[i], tickets, 0);
            }
        }
        
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
    
        return answer; 
    }
    
    public void dfs(String route, String[] now, String[][] tickets, int cnt) {
        if(cnt == tickets.length - 1) {
            route += " " + now[1];
            list.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(now[1].equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(route + " " + tickets[i][0], tickets[i], tickets, cnt + 1);
                visit[i] = false;
            }
        }
    }
}