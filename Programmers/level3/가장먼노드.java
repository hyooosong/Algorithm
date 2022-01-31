import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] count = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for(int[] vertax : edge) {
            list.get(vertax[0]).add(vertax[1]);
            list.get(vertax[1]).add(vertax[0]);
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        visit[1] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int i : list.get(now)) {
                if(!visit[i]) {
                    count[i] = count[now] + 1;
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
        
        int max = 0;
        for(int cnt : count) {
            if(max < cnt) {
                max = cnt;
                answer = 1;
            } else if(max == cnt) answer++;
        }

        return answer;
    }
}