import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashSet<String> set = new HashSet(Arrays.asList(report));
        String[] copyReport = set.toArray(new String[0]);
        
        String[] uid = new String[copyReport.length];
        String[] rid = new String[copyReport.length];
        
        for(int i = 0; i < copyReport.length; i++) {
            String[] arr = copyReport[i].split(" ");
            uid[i] = arr[0];
            rid[i] = arr[1];
        }
        
        HashMap<String, Integer> map = new HashMap();
        for(String user : rid) {
            map.put(user, map.getOrDefault(user, 0) + 1);
        }
        
        for(int i = 0; i < rid.length; i++) {
            if(map.get(rid[i]) >= k) {
                int idx = Arrays.asList(id_list).indexOf(uid[i]);
                answer[idx]++;
            }
        }
        
        return answer;
    }
}