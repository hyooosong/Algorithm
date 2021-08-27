import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList();
        
        for(String s : skill_trees){
            for(int i = 0; i < skill.length(); i++) {
                list.add(s.indexOf(skill.charAt(i)));
            }
            
            int min = -2;
            for(int i = 0; i < list.size(); i++) {
                if(min < list.get(i)) {
                    if(min == -1) break;
                    else min = list.get(i);
                } else {
                    if(list.get(i) != -1) break;
                    else min = list.get(i);
                }
                
                if(i == list.size() - 1) answer++;
            }
            
            list.clear();
        }
    
        return answer;
    }
}