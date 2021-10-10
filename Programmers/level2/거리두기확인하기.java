import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            answer[i] = possible(places[i]);
        }
        return answer;
    }
    
    public int possible(String[] places) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(places[i].charAt(j) == 'P')
                    if(!bfs(places, i, j))
                        return 0;
            }
        }
        return 1;
    }
    
    public boolean bfs(String[] places, int x, int y) {
        boolean[][] visit = new boolean[5][5];
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(x, y));
        visit[x][y] = true;
        
        while(!queue.isEmpty()) {
            Node next = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];
                int manhattan = Math.abs(nx - x) + Math.abs(ny - y);
                
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                
                if(!visit[nx][ny] && manhattan <= 2) {
                    visit[nx][ny] = true;
                    if(places[nx].charAt(ny) == 'X') continue;
                    else if(places[nx].charAt(ny) == 'P') return false;
                    else queue.add(new Node(nx, ny));
                }
            }
        }
        return true;
    }
}

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}