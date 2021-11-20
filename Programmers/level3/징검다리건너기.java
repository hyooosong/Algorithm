class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 200000000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(possible(mid, k, stones)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean possible(int friends, int k, int[] stones) {
        int cnt = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < friends) cnt++;
            else cnt = 0;
            
            if(cnt >= k) return false;
        }
        
        return true;
    }
}