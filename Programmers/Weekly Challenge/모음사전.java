class Solution {
    public int solution(String word) {
        int answer = 0;
        int step = 781;
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
        
        for(char c : word.toCharArray()) {
            for(int j = 0; j < alphabet.length; j++) {
                if(alphabet[j] == c)
                    answer += step * j + 1;
            }
            step /= 5;
        }
        
        return answer;
    }
}