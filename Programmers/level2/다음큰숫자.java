class Solution {
    public int solution(int n) {
        int count = countOne(Integer.toString(n, 2));
        
        for(int i = 1; i < n; i++) {
            if(countOne(Integer.toString(n+i, 2)) == count) 
                return n + i;
        }
        
        return 0;
    }
    
    public int countOne(String num) {
        int count = 0;
        
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '1') count++;
        }
        
        return count;
    }
}