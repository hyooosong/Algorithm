import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int cam = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
            if(cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}