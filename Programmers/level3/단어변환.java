class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visit;
    
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visit[i]) continue;
            
            int same = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j))
                    same++;
            }
            
            if(same == begin.length() - 1) {
                visit[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visit[i] = false;
            }
        }
        
    }
}