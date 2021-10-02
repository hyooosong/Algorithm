import java.util.ArrayList;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        ArrayList<Integer> list = new ArrayList();
        int idx = 0;
        
        for(int user : enter) {
            list.add(user);
            
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == user) {
                    answer[list.get(j) - 1] += list.size() - 1;
                } else {
                    answer[list.get(j) - 1]++;
                }
            }
            
            while(idx < answer.length && list.contains(leave[idx])) {
                 list.remove(Integer.valueOf(leave[idx++]));
            }
        }
        
        return answer;
    }
}