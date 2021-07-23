class Solution {
    int[][] phone = {
        {3,1}, {0,0}, {0,1}, {0,2}, {1,0}, 
        {1,1}, {1,2}, {2,0}, {2,1}, {2,2} 
    };
    int[] left = {3, 0};
    int[] right = {3, 2};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        for(int now : numbers) {
            if(finger(now, hand) == "L") {
                answer += "L";
                left = phone[now];
            } else {
                answer += "R";
                right = phone[now];
            }
        }
        return answer;
    }
    
    public int distance(int[] finger, int[] now) {
        return Math.abs(finger[0] - now[0]) + Math.abs(finger[1] - now[1]);
    }
    
    public String finger(int now, String hand) {
        switch(now) {
            case 1: case 4: case 7: {
                return "L"; 
            }
            case 3: case 6: case 9: {
                return "R"; 
            }
            default: {
                if(distance(left, phone[now]) > distance(right, phone[now])) return "R"; 
                if(distance(left, phone[now]) < distance(right, phone[now])) return "L";
            }
        }
    
        return hand.equals("left") ? "L" : "R";
    }

}