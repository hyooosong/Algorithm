import java.util.ArrayList;

class Solution {
    boolean[] visit = new boolean[3];
    String[] operator = {"+", "-", "*"};
    String[] temp = new String[3];
    ArrayList<String> op = new ArrayList();
    ArrayList<Long> num = new ArrayList();
    long answer = 0;
    
    public long solution(String expression) {
        for(String s : expression.split("[-,+,*]")) {
            if(!s.isEmpty()) num.add(Long.valueOf(s));
        }

        for(String s : expression.split("[^-,+,*]")) {
            if(!s.isEmpty()) op.add(s);
        }
        
        dfs(0);
        
        return answer;
    } 
    
    public void dfs(int count) {
        if(count == 3) {
            solve();
        } else {
            for(int i = 0; i < 3; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    temp[count] = operator[i];
                    dfs(count + 1);
                    visit[i] = false;
                }
            }
        }
    }
    
    public void solve() {
        ArrayList<Long> copyNum = new ArrayList(num);
        ArrayList<String> copyOp = new ArrayList(op);
        
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < copyOp.size(); j++) {
                if(temp[i].equals(copyOp.get(j))) {
                    Long result = calculate(copyNum.remove(j), copyNum.remove(j), copyOp.remove(j));
                    copyNum.add(j, result);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(copyNum.get(0)));
    }
    
    public long calculate(Long o1, Long o2, String op) {
        switch(op) {
            case "+" : 
                return o1 + o2;
            case "-" :
                return o1 - o2;
            case "*" :
                return o1 * o2;
        }
        return 0;
    }
}