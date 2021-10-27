class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int last_idx = a.length - 1;
        int first = a[0];
        int last = a[last_idx];
        
        for(int i = 1; i < last_idx; i++) {
            if(a[i] < first) {
                first = a[i];
                answer++;
            }
            
            if(a[last_idx - i] < last) {
                last = a[last_idx - i];
                answer++;
            }
            
            if(first == last) {
                answer--;
                break;
            }
        }
        
        return answer;
    }
}