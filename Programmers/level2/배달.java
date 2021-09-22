import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] distance = new int[N][N];
        
        for(int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < road.length; i++) {
            int x = road[i][0] - 1;
            int y = road[i][1] - 1;
            int w = road[i][2];
            
            if(distance[x][y] > w) {
                distance[x][y] = w;
                distance[y][x] = w;   
            }
        }
        
        boolean[] visit = new boolean[N];
        int[] result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return result[o1] - result[o2];
            }
        });
        
        result[0] = 0;
        queue.add(0);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(!visit[now]) {
                visit[now] = true;
                
                for(int i = 0; i < N; i++) {
                    if(distance[now][i] == Integer.MAX_VALUE) 
                        continue;
                    if(result[i] > result[now] + distance[now][i]) {
                        result[i] = result[now] + distance[now][i];
                        queue.add(i);
                    }
                }
            }   
        }
        
        for(int i : result) {
            if(i <= K) answer++;
        }
        
        return answer;
    }
}