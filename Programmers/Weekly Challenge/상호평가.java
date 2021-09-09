class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        
        for(int student = 0; student < scores.length; student++) {
            int self = scores[student][student];
            int min = 101;
            int max = 0;
            int count = 0;
            int sum = 0;
            int length = scores.length;
            
            for(int i = 0; i < scores.length; i++) {
                sum += scores[i][student];
                min = Math.min(min, scores[i][student]);
                max = Math.max(max, scores[i][student]);
                
                if(self == scores[i][student]) count++;
            }
            
            if(self == min || self == max) {
                if(count == 1) {
                    sum -= self;
                    length--;
                }
            }
            answer.append(grade(sum, length));
        }
        
        return answer.toString();
    }
    
    public String grade(int sum, int length) {
        double avg = (double) sum / length;
        if(avg >= 90) return "A";
        else if(avg >= 80) return "B";
        else if(avg >= 70) return "C";
        else if(avg >= 50) return "D";
        else return "F";
    }
}