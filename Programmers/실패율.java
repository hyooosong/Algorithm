import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] clear = new int[N+1];
        HashMap<Integer, Double> hm = new HashMap();
        int user = stages.length;
        double fail = 0.0;
        
        for(int i : stages) {
            clear[i-1]++;
        }
        
        for(int i = 0; i < N; i++) {
            fail = (double) clear[i] / user;
            
            if(Double.isNaN(fail) || user == 0) {
                hm.put(i + 1, 0.0);
            } else {
                hm.put(i + 1, fail);
                user -= clear[i];
            }
        }
        
        ArrayList<Integer> result = new ArrayList(hm.keySet());
        
        Collections.sort(result, 
                    (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}