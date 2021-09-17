class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int idx = 1; idx <= s.length() / 2; idx++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, idx);
            String str = "";
            int count = 1;
            
            for(int i = idx; i < s.length(); i += idx) {
                str = i + idx > s.length() ?
                    s.substring(i) : s.substring(i, i + idx);
                
                if(prev.equals(str))
                    count++;
                else {
                    if(count != 1) sb.append(count);
                    sb.append(prev);
                    prev = str;
                    count = 1;
                }
            }
            
            if(count != 1) sb.append(count);
            sb.append(str);
     
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}