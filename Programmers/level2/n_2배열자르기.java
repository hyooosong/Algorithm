class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int idx = 0;

        for(long i = left; i <= right; i++) {
            int value = (int) (i / n) + 1;
            int remain = (int) (i % n) + 1;
            answer[idx++] = value >= remain ? value : remain;
        } 
        
        return answer;
    }
}