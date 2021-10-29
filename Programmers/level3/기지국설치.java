class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int size = 2 * w + 1;
        
        for(int stat : stations) {
            int start = stat - w;
            int end = stat + w;
            
            if(now <= start)
                answer += count(start - now, size);
            
            now = end + 1;
        }
        
        if(now <= n) 
            answer += count(n - now + 1, size);
        
        return answer;
    }
    
    public int count(int range, int size) {
        int result = range / size;
        if(range % size != 0)
            result++;
        
        return result;
    }
}