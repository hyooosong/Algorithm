class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - GCD(w, h));
    }
    
    public int GCD(int a, int b) {
        if(b == 0)
            return a;
        
        return GCD(b, a % b);
    }
}