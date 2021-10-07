import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visit;
    
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        return bfs(maps, 0, 0);
    }
    
    public int bfs(int[][] maps, int x, int y) {
        int width = maps.length;
        int height = maps[0].length;
        
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(x, y, 1));
        visit[x][y] = true;
        
        while(!queue.isEmpty()) {
            Node next = queue.poll();
            
            if(next.x == width - 1 && next.y == height - 1)
                return next.cost;
            
            for(int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];
                if(nx < 0 || nx >= width || ny < 0 || ny >= height) continue;

                if(maps[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny, next.cost + 1));
                }
            }
        }
        
        return -1;
    }
}

class Node {
    int x;
    int y;
    int cost;
    
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}