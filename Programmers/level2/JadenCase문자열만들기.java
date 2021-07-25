class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean first = false;
        
        answer.append(String.valueOf(s.charAt(0)).toUpperCase());
        
        for(int i = 1; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if(first)
                answer.append(str.toUpperCase());
            else 
                answer.append(str.toLowerCase());
            
            first = str.equals(" ") ? true : false;
        }
        return answer.toString();
    }
}