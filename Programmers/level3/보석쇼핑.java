import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class Solution { 
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap();
        Queue<String> queue = new LinkedList();
        int idx = 0;
        int start = 0;
        int len = 100000;
        
        for(int i = 0; i < gems.length; i++) {
            String type = gems[i];
            map.put(type, map.getOrDefault(type, 0) + 1);
            queue.add(type);
            
            while(map.get(queue.peek()) > 1) {
                map.put(queue.peek(), map.get(queue.poll()) - 1);
                idx++;
            }
            
            if(map.size() == set.size() && len > i - idx) {
                len = i - idx;
                start = idx + 1;
            }
        }
        
        return new int[]{start, start + len};
    }
    
}