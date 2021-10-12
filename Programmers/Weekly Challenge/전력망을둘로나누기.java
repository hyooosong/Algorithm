import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        for(int i = 0; i < wires.length; i++) {
            int o1 = BFS(wires, i);
            int o2 = n - o1;
            int result = Math.abs(o1 - o2);
            if(answer > result) 
                answer = result;
        }
        
        return answer;
    }
    
    public int BFS(int[][] wires, int idx) {
        Queue<Integer> queue = new LinkedList();
        ArrayList<int[]> list = new ArrayList();
        int cnt = 0;
        
        for(int[] data : wires) {
            list.add(data);
        }
        
        queue.add(list.get(idx)[0]);
        list.remove(idx);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);
                boolean flag = true;
               
                if(arr[0] == node) {
                    queue.add(arr[1]);
                    flag = false;
                }
                if(arr[1] == node) {
                    queue.add(arr[0]);
                    flag = false;
                }
                if(!flag) {
                    list.remove(arr);
                    i--;
                }
            }
            
            cnt++;
        }
        return cnt;
    }
}