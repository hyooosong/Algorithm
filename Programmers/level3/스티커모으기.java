class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) 
            return sticker[0];
        
        if(sticker.length == 2) 
           return Math.max(sticker[0], sticker[1]);
        
        int last = sticker.length - 1;
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
 
        dp1[0] = dp1[1] = sticker[0];
        dp2[1] = sticker[1];
        
        for(int i = 2; i < last; i++) {
            dp1[i] = Math.max(sticker[i] + dp1[i-2], dp1[i-1]);
            dp2[i] = Math.max(sticker[i] + dp2[i-2], dp2[i-1]);
        }
        
        dp2[last] = Math.max(sticker[last] + dp2[last-2], dp2[last-1]);
        
        return Math.max(dp1[last - 1], dp2[last]);
    }
}