class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                sb.append(" ");
                continue;
            }
            
            if('a' <= ch && ch <= 'z' && ch + n > 122) {
                sb.append((char)(ch + n - 26));
                continue;
            }
            
            if('A' <= ch && ch <= 'Z' && ch + n > 90) {
                sb.append((char)(ch + n - 26));
                continue;
            }
            
            sb.append((char)(ch + n));
        }
        
        return sb.toString();
    }
}