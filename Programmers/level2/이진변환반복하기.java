class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int count = 0;
        
        while(!s.equals("1")) {
            int zero = s.length() - s.replace("0","").length();
            zeroCount += zero;
            s = s.replace("0","");
            s = Integer.toString(s.length(), 2);
            count++;
        }
        
        int[] answer = {count, zeroCount};
        return answer;
    }
}