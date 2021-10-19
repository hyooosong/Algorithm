class Solution {
    public int solution(String s) {
        int answer = 1;

        for(int i = s.length(); i > 1; i--) {
            for(int j = 0; j + i <= s.length(); j++) {
                boolean isPalin = true;
                
                for(int k = 0; k < i / 2; k++) {
                    if(s.charAt(j + k) != s.charAt(j + i - k - 1)) {
                        isPalin = false;
                        break;
                    }
                }
                
                if(isPalin) return i;
            }
        }

        return answer;
    }
}