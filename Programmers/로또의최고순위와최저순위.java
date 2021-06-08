class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeroCount = 0;
        
        for(int i : lottos) {
            if (i == 0) {
                zeroCount++;
            } else {
                for (int j : win_nums) {
                    if(i == j)
                        count++;
                }
            }
        }
        
        int[] answer = {rank(count + zeroCount), rank(count)};
        return answer;
    }
    
    public int rank(int count) {
        switch(count) {
            case 2: return 5;
            case 3: return 4;
            case 4: return 3;
            case 5: return 2;
            case 6: return 1;
            default: return 6;
        }
    }
}