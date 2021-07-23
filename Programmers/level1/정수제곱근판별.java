class Solution {
    public long solution(long n) {
        long answer = 0;
        long plus = 0;
        double intCheck = Math.sqrt(n);

        if(intCheck % 1 == 0) {
            plus = (long)intCheck + 1;
            answer = (long)Math.pow(plus,2);
        } else {
            answer = -1;
        }

        return answer;
    }
}