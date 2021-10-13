import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<int[]> list = new ArrayList();
    int minX = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        int row = 0;
        int col = 0;
        
        for(int i = 0; i < line.length; i++) {
            for(int j = i+1; j < line.length; j++) {
                checkMeet(line[i], line[j]);
            }
        }
        
        for(int i = 0; i < list.size(); i++) {
            list.get(i)[0] -= minX;
            list.get(i)[1] = Math.abs(list.get(i)[1] - maxY);
            if(col < list.get(i)[1]) col = list.get(i)[1];
            if(row < list.get(i)[0]) row = list.get(i)[0];
        }
        
        String[] answer = new String[col + 1];
        
        for(int i = 0; i <= col; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= row; j++) {
                if(containsValue(new int[]{j, i})) sb.append("*");
                else sb.append(".");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    public boolean containsValue(int[] value) {
        for(int[] arr : list) {
            if(Arrays.equals(arr, value)) {
                list.remove(arr);
                return true;
            }
        }
        return false;
    }
    
    public void checkMeet(int[] o1, int[] o2) {
        long A = o1[0];
        long B = o1[1];
        long C = o2[0];
        long D = o2[1];
        long E = o1[2];
        long F = o2[2];
        
        long value = A * D - B * C;
        if(value == 0) return;
        
        long x = B * F - E * D;
        long y = E * C - A * F;
        
        if(x % value == 0 && y % value == 0) {
            x /= value;
            y /= value;
            int nx = (int) x;
            int ny = (int) y;
            if(minX > nx) minX = nx;
            if(maxY < ny) maxY = ny;
            list.add(new int[]{nx, ny});
        }
    }
}