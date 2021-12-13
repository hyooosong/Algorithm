import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int[] arr : costs) {
            int prev = find(arr[0]);
            int next = find(arr[1]);
            
            if(prev == next) continue;
            
            answer += arr[2];
            parent[next] = prev;
        }

        
        return answer;
    }
    
    public int find(int n) {
        if(parent[n] == n) return n;
        return find(parent[n]);
    }
}