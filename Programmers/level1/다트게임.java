import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> score = new ArrayList();
        ArrayList<String> opt = new ArrayList();
 
        for(String s : dartResult.split("[^0-9]")) {
            if(!(s.isEmpty())) 
                score.add(Integer.parseInt(s));
        }
        
        for(String s : dartResult.split("[0-9]")) {
            if(!(s.isEmpty())) 
                opt.add(s);
        }
        
        for(int i = 0; i < opt.size(); i++) {
            if(opt.get(i).contains("D")) 
                score.set(i, (int) Math.pow(score.get(i), 2));
            
            if(opt.get(i).contains("T")) 
                score.set(i, (int) Math.pow(score.get(i), 3));
            
            if(opt.get(i).contains("#")) 
                score.set(i, score.get(i) * -1);
            
            if(opt.get(i).contains("*")) {
                score.set(i, score.get(i) * 2);
                if(i != 0)
                    score.set(i - 1, score.get(i - 1) * 2);
            }
        }
        
        for(int i : score) {
            answer += i;
        }
        
        return answer;
    }
}