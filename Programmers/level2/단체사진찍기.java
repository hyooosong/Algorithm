class Solution {
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] visit = new boolean[8];
    int answer = 0;
    
    public int solution(int n, String[] data) {
        dfs("", data);
        return answer;
    }
    
    public void dfs(String order, String[] data) {
        if(order.length() == 7) {
            if(possible(data, order)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visit[i]) {
                visit[i] = true;
                String orders = order + friends[i];
                dfs(orders, data);
                visit[i] = false;
            }
        }
    }
    
    public boolean possible(String[] data, String order) {
        for(String s : data) {
            int o1 = order.indexOf(s.charAt(0));
            int o2 = order.indexOf(s.charAt(2));
            char op = s.charAt(3);
            int distance = s.charAt(4) - '0';
            
            switch(op) {
                case '=' : 
                    if(!(Math.abs(o1 - o2) == distance + 1)) return false; break;
                case '<' : 
                    if(!(Math.abs(o1 - o2) < distance + 1)) return false; break;
                case '>' :  
                    if(!(Math.abs(o1 - o2) > distance + 1)) return false; break;
            }
        }
        
        return true;
    }
}